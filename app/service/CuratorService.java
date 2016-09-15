//package service;
//
//import domain.ZkNodeInfo;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.CuratorFrameworkFactory;
//import org.apache.curator.framework.api.Pathable;
//import org.apache.curator.retry.RetryNTimes;
//import org.apache.log4j.Logger;
//import org.apache.zookeeper.data.Stat;
//import org.w3c.dom.stylesheets.LinkStyle;
//
//
//import java.nio.charset.Charset;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.IllegalFormatException;
//import java.util.List;
//
///**
// * Created by jianwl on 2016/1/11.
// */
//public class CuratorService {
//
//    private static final Logger logger = Logger.getLogger(CuratorService.class);
//    private static String zk_Address = "192.168.180.78:2181";
//    private final static String ZK_PATH = "/mytest";
//    private static CuratorFramework client = null;
//    /**
//     * 创建ZK客户端
//     * @param zkAddress
//     * @return
//     */
//
//    //默认的客户端节点;
//    static {
//        logger.info("========= defualt zkClient start =====" + zk_Address);
//        client = CuratorFrameworkFactory.newClient(zk_Address, new RetryNTimes(10, 5000));
//        client.start();
//    }
//
//    public static void createClient(String zkAddress){
//        logger.info("========= create zkClient ===========");
//        client = CuratorFrameworkFactory.newClient(zkAddress, new RetryNTimes(10, 5000));
//        client.start();
//        /*try {
//            Thread.sleep(1000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }*/
//    }
//
//
//    public static String getCurrentZkAddress(){
//        return zk_Address;
//    }
//    /**
//     *  树形结构展示所有节点
//     * @param path
//     * @return
//     */
//    public static String readXML(String path){
//        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
//        sb.append("<tree id='0'>");
//
//        try{
//            printTree(path,sb);
//        }catch(Exception e){
//            logger.error("Fail to printTree",e);
//        }
//        sb.append("</tree>");
//        //logger.info("tree == " + sb.toString());
//        return sb.toString();
//    }
//
//    private static void printTree(String path,StringBuilder sb) throws Exception {
//        sb.append("<item text=\"" + path + "\" id=\"" + path + "\"");
//        Stat stat = new Stat();
//        List<String> list = client.getChildren().storingStatIn(stat).forPath(path);
//
//        Collections.sort(list);
//
//        if(stat.getNumChildren() > 0){
//            sb.append(" open='1' im0='folderClosed.gif' im1='folderOpen.gif' im2='folderClosed.gif'>");
//            for(String child : list){
//                String x = path.endsWith("/") ? "" : "/";
//                String childPath = path + x + child;
//                printTree(childPath,sb);
//            }
//        } else {
//            sb.append(">");
//        }
//        sb.append("</item>");
//    }
//
//    /**
//     * 获取节点数据
//     * @param path
//     * @return
//     */
//    public static ZkNodeInfo getZkNodeData(String path){
//        logger.info("=====getNodeInfo======= path === " + path);
//        path = validPath(path);
//        Stat stat = new Stat();
//        ZkNodeInfo zkNodeInfo = new ZkNodeInfo();
//        String data = "";
//        try {
//            byte zkData[] = client.getData().storingStatIn(stat).forPath(path);
//            if(zkData != null){
//                data = new String(zkData, Charset.forName("UTF-8"));
//            }
//            logger.info("=====Stat=====" + stat);
//        } catch (Exception e) {
//            logger.error("========get Node Data Error=======");
//        }
//        zkNodeInfo.setZkNodeInfo(zkNodeInfo, stat, data, path);
////        logger.info("=======ZK Node Info =====" + zkNodeInfo);
//
//        return zkNodeInfo;
//    }
//
//    /**
//     * 获取子节点
//     * @param path
//     * @return
//     */
//
//    public static String getChildPathByPath(String path){
//        logger.info("=====getChildNodeByPath======= path === " + path);
//        path = validPath(path);
//        List<String> childPathList = null;
//        StringBuilder builder = new StringBuilder("");
//        try {
//            childPathList = client.getChildren().forPath(path);
//
//            if(childPathList != null){
//                for(String childPath : childPathList){
//                    builder.append(childPath+",");
//                }
//            }
//        } catch (Exception e) {
//            logger.error("Error for getting child nodes under current path. [path] = " + path);
//        }
//
//        int strLen = builder.length();
//        return builder.length() >= 1 ? builder.toString().substring(0,strLen-1) : builder.toString();
//    }
//
//    //验证路径
//    private static String validPath(String path){
//        logger.info("======= validPath =====");
//        String validPath = null;
//        if(path == null){
//            validPath = "/";
//        }else if(path.trim().length() == 0) {
//            validPath = "/";
//        }else if(path.endsWith("/") && path.length() > 1){
//            validPath = path.substring(0,path.length()-1);
//        }else{
//            validPath = path;
//        }
//        logger.info("======= before valid path = " + path + "======== after valid path = " + validPath + "========");
//        return validPath;
//    }
//
//    /**
//     * 切换ZK连接；
//     * @param hostname
//     * @param port
//     * @return
//     */
//    public static void switchZK(String hostname,String port){
//        if(StringUtils.isBlank(hostname)){
//            throw new IllegalArgumentException("===== ip is not blank ====== ip =====" + hostname);
//        }
//        if(StringUtils.isBlank(port)){
//            throw new IllegalArgumentException("===== port is not blank ===== port ==" + port);
//        }
//        String zkAddress = hostname + ":" + port;
//        client.close();
//        createClient(zkAddress);
//        logger.info("=========Switch ZK============= zkAddress ==="  + zk_Address);
//    }
//
//    /**
//     * 删除ZK节点
//     * @param path
//     */
//    public static void deleteZkNode(String path){
//        logger.info("====== delete ZK Node ========");
//        path = validPath(path);
//
//        if(StringUtils.equalsIgnoreCase(path,"/")){
//            throw new IllegalArgumentException("Root path can not be deleted");
//        }
//        if(StringUtils.startsWithIgnoreCase(path,"/zookeeper")){
//            throw new IllegalArgumentException("zookeeper node can not be deleted");
//        }
//
//        try {
//            client.delete().forPath(path);
//        } catch (Exception e) {
//            logger.error("====== delete ZK Node Error",e);
//        }
//    }
//
//
//    /**
//     * 修改ZkNode路径和数据信息
//     * @param path
//     * @param data
//     */
//    public static void updateZkNode(String path,String data){
//        logger.info("============update zkNode ============");
//        //过滤路径
//        path = validPath(path);
//
//        if(StringUtils.equalsIgnoreCase(path,"/")){
//            throw new IllegalArgumentException("Root path can not be modifed");
//        }
//        if(StringUtils.startsWithIgnoreCase(path,"/zookeeper")){
//            throw new IllegalArgumentException("zookeeper node can not be modifed");
//        }
//
//        try {
//            client.setData().forPath(path, data.getBytes(Charset.forName("UTF-8")));
//
//        } catch (Exception e) {
//            logger.error("============ modify zk Node Error =========== path =" + path + "===== data = " + data,e);
//        }
//    }
//
//    /**
//     * 添加子节点
//     * @param parentPath
//     * @param childpath
//     * @param data
//     */
//
//    public static void addZkNode(String parentPath,String childpath,String data){
//        logger.info("========== add ZkNode ============");
//        if(StringUtils.isBlank(parentPath)){
//            throw new NullPointerException();
//        } else if(StringUtils.startsWithIgnoreCase(parentPath,"/zookeeper")){
//            throw new IllegalArgumentException("zookeeper node can not be modifed");
//        }
//
//        if(StringUtils.isBlank(childpath)){
//            throw new NullPointerException();
//        }else if(childpath.trim().endsWith("/")){
//            throw new IllegalArgumentException(" new add child Path can not end with '/' ");
//        }
//
//        if(!parentPath.startsWith("/")){
//            parentPath = "/".concat(parentPath);
//        }else if(!parentPath.endsWith("/")){
//            parentPath = parentPath.concat("/");
//        }
//
//        String path = parentPath.concat(childpath);
//        validPath(path);
//        logger.info("======= new zk node path = " + path + " ============");
//        try {
//            Stat stat = client.checkExists().forPath(path);
//            logger.info("=========path is existed ============ stat " + stat);
//            if(stat == null) {
//                client.create().forPath(path, data.getBytes(Charset.forName("UTF-8")));
//            }
//        } catch (Exception e) {
//            logger.error("======= add ZkNode Error ===== path" + path,e);
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
////        CuratorFramework client = createClient(ZK_ADDRESS);
////        client.start();
////        String path = "/";
////        getZkNodeData(path);
//
////        String parentPath  = "/consumers/liu_yun_group1/ids21213/";
////        String childPath = "33";
////        addZkNode("/admin/", "test", "dsfdsfdsf");
////        updateZkNode("/admin/test33","iiiiiiiiii");
////
////        deleteZkNode(client,"/consumers/liu_yun_group1/ids/21");
////        switchZK("192.168.180.79","2181");
////
////        getZkNodeData("/brokers/topics/my-topic1/partitions/1/state",client);
////        readXML("/");
//
////        String str = "192.168.180.78";
////        System.out.println(str.split("/.").length);
//    }
//}
