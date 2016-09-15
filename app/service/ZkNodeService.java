package service;

import com.mob.hubble.domain.ZkCluster;
import com.mob.hubble.service.ZkClusterService;
import domain.ZkNodeInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.log4j.Logger;
import org.apache.zookeeper.client.FourLetterWordMain;
import org.apache.zookeeper.data.Stat;
import play.mvc.Result;
import utils.ServiceHelper;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

/**
 * Created by jianwl on 2016/1/19.
 */
public class ZkNodeService {
    private static final Logger logger = Logger.getLogger(ZkNodeService.class);
    private static final String ROOT_PATH = "/";
    private static CuratorFramework client = null;
    private static String ZK_ADDRESS = null;


    /**
     *
     * @return
     */
//    public static void get


//    public static void  getZkStatus(){
//        try {
//            String result = FourLetterWordMain.send4LetterWord("192.168.180.78",2181,"srvr");
//            String isro = FourLetterWordMain.send4LetterWord("192.168.180.78",2181,"ruok");
//            logger.info("======= result = " + result);
//            logger.info("======= isro = " + isro);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        getZkStatus();
//    }

    public static String getCurrentZkAddress(){
        return ZK_ADDRESS;
    }

    public static void createClient(String hostname,String port){
        logger.info("========= create zkClient ===========");
        if(StringUtils.isBlank(hostname)){
            throw new IllegalArgumentException("[create Client] hostname can not be null === hostname =" +hostname);
        }
        if(StringUtils.isBlank(port)){
            throw new IllegalArgumentException("[create Client] port can not be null === port =" +port);
        }
        ZK_ADDRESS = hostname + ":" + port;
        client = CuratorFrameworkFactory.newClient(ZK_ADDRESS, new RetryNTimes(10, 5000));
        client.start();
    }
    public static String readXML(String hostName,String port){
        boolean unfold_flag = true;
        if(StringUtils.isBlank(hostName) || StringUtils.isBlank(port)){
            ZkClusterService zkClusterService = ServiceHelper.getZkClusterService();
            List<ZkCluster> zkClusterList =  zkClusterService.getZkClusterList();
            if(zkClusterList != null && zkClusterList.size() >= 1){
                hostName = zkClusterList.get(0).getHostName();
                port = zkClusterList.get(0).getPort();
            }
        }

        if(client == null){
            createClient(hostName,port);
        }else {
//            logger.info("====Close origin client before changing ZK =====");
            client.close();
            createClient(hostName,port);
        }

        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<tree id='0'>");
        try{
            printTree(ROOT_PATH,sb,unfold_flag);
        }catch(Exception e){
            logger.error("Fail to printTree",e);
        }
        sb.append("</tree>");
//        logger.info("tree == " + sb.toString());
        return sb.toString();
    }

    private static void printTree(String path,StringBuilder sb,Boolean unfold_flag) throws Exception {
        sb.append("<item text=\"" + path + "\" id=\"" + path + "\"");
        Stat stat = new Stat();
        List<String> list = client.getChildren().storingStatIn(stat).forPath(path);

        Collections.sort(list);

        if(stat.getNumChildren() > 0){
            if(unfold_flag){
                sb.append(" open='1' im0='folderClosed.gif' im1='folderOpen.gif' im2='folderClosed.gif'>");
                unfold_flag = false;
            }else{
                sb.append(" im0='folderClosed.gif' im1='folderOpen.gif' im2='folderClosed.gif'>");
            }
            for(String child : list){
                String x = path.endsWith("/") ? "" : "/";
                String childPath = path + x + child;
                printTree(childPath,sb,unfold_flag);
            }
        } else {
            sb.append(">");
        }
        sb.append("</item>");
    }


    /**
     * 获取节点数据
     * @param path
     * @return
     */
    public static ZkNodeInfo getZkNodeData(String path){
        logger.info("=====getZkNodeData=============");
        path = validPath(path);
        Stat stat = new Stat();
        ZkNodeInfo zkNodeInfo = new ZkNodeInfo();
        String data = "";
        try {
            byte zkData[] = client.getData().storingStatIn(stat).forPath(path);
            if(zkData != null){
                data = new String(zkData, Charset.forName("UTF-8"));
            }
        } catch (Exception e) {
            logger.error("========get Node Data Error=======");
        }
        zkNodeInfo.setZkNodeInfo(zkNodeInfo, stat, data, path);

        return zkNodeInfo;
    }

    /**
     * 获取子节点
     * @param path
     * @return
     */

    public static String getChildPathByPath(String path){
        logger.info("=====getChildNodeByPath=========");
        path = validPath(path);
        List<String> childPathList = null;
        StringBuilder builder = new StringBuilder("");
        try {
            childPathList = client.getChildren().forPath(path);

            if(childPathList != null){
                for(String childPath : childPathList){
                    builder.append(childPath+",");
                }
            }
        } catch (Exception e) {
            logger.error("Error for getting child nodes under current path. [path] = " + path,e);
        }

        int strLen = builder.length();
        return builder.length() >= 1 ? builder.toString().substring(0,strLen-1) : builder.toString();
    }

    //验证路径
    private static String validPath(String path){
        String validPath = null;
        if(path == null){
            validPath = "/";
        }else if(path.trim().length() == 0) {
            validPath = "/";
        }else if(path.endsWith("/") && path.length() > 1){
            validPath = path.substring(0,path.length()-1);
        }else{
            validPath = path;
        }
        logger.info("======= before valid path = " + path + "======== after valid path = " + validPath + "========");
        return validPath;
    }


    /**
     * 删除ZK节点
     * @param path
     */
    public static void deleteZkNode(String path){
        logger.info("====== delete ZK Node ========");
        path = validPath(path);

        if(StringUtils.equalsIgnoreCase(path,"/")){
            throw new IllegalArgumentException("Root path can not be deleted");
        }
        if(StringUtils.startsWithIgnoreCase(path,"/zookeeper")){
            throw new IllegalArgumentException("zookeeper node can not be deleted");
        }

        try {
            client.delete().forPath(path);
        } catch (Exception e) {
            logger.error("====== delete ZK Node Error",e);
        }
    }


    /**
     * 修改ZkNode路径和数据信息
     * @param path
     * @param data
     */
    public static void updateZkNode(String path,String data){
        logger.info("============update zkNode ============");
        //过滤路径
        path = validPath(path);

        if(StringUtils.equalsIgnoreCase(path,"/")){
            throw new IllegalArgumentException("Root path can not be modifed");
        }
        if(StringUtils.startsWithIgnoreCase(path,"/zookeeper")){
            throw new IllegalArgumentException("zookeeper node can not be modifed");
        }

        try {
            client.setData().forPath(path, data.getBytes(Charset.forName("UTF-8")));

        } catch (Exception e) {
            logger.error("============ modify zk Node Error =========== path =" + path + "===== data = " + data,e);
        }
    }

    /**
     * 添加子节点
     * @param parentPath
     * @param childpath
     * @param data
     */

    public static void addZkNode(String parentPath,String childpath,String data){
        logger.info("========== add ZkNode ============");
        if(StringUtils.isBlank(parentPath)){
            throw new NullPointerException();
        } else if(StringUtils.startsWithIgnoreCase(parentPath,"/zookeeper")){
            throw new IllegalArgumentException("zookeeper node can not be modifed");
        }

        if(StringUtils.isBlank(childpath)){
            throw new NullPointerException();
        }else if(childpath.trim().endsWith("/")){
            throw new IllegalArgumentException(" new add child Path can not end with '/' ");
        }

        if(!parentPath.startsWith("/")){
            parentPath = "/".concat(parentPath);
        }else if(!parentPath.endsWith("/")){
            parentPath = parentPath.concat("/");
        }

        String path = parentPath.concat(childpath);
        validPath(path);
        try {
            Stat stat = client.checkExists().forPath(path);
            logger.info( "========== [addZkNode] stat =" + stat +"=============");
            if(stat == null) {
                client.create().forPath(path, data.getBytes(Charset.forName("UTF-8")));
            }
        } catch (Exception e) {
            logger.error("======= add ZkNode Error ===== path" + path,e);
        }
    }

    /**
     *
     */
    /**
     * 获取所有注册过的主机
     */
    public static String getRegisterHostName(){
        ZkClusterService zkClusterService = ServiceHelper.getZkClusterService();
        List<ZkCluster> list = zkClusterService.getZkClusterList();
        StringBuilder builder = new StringBuilder("");

        if(list != null){
            for(ZkCluster zkCluster : list){
                String hostName = zkCluster.getHostName();
                builder.append(hostName+",");
            }
        }
        int len = builder.length();
        String result = len > 1 ? builder.toString().substring(0,len-1) : builder.toString();

        return result ;
    }
}
