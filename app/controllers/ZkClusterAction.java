package controllers;


import com.mob.hubble.domain.ZkCluster;
import com.mob.hubble.service.ZkClusterService;
import domain.ZkClientDetail;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.zookeeper.client.FourLetterWordMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import scala.util.parsing.json.JSONObject;
import service.ZkNodeService;
import utils.ServiceHelper;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import utils.StringUtil;
import views.html.*;

import javax.xml.crypto.Data;

/**
 * Created by jianwl on 2016/1/19.
 */
public class ZkClusterAction extends Controller {
    private static final Logger logger = Logger.getLogger(ZkClusterAction.class);
    private static ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);

    public static void main(String[] args) {

    }

    public static Result clientDetail(String zkHostName,String ZkPort){
        String hostName;
        String port;
        Long send = 0L;
        Long received = 0L;
        String establishTime = "";
        String lastResponseTime = "";
        Long maxLatency = 0L;

        List<ZkClientDetail> zkClientDetailList = new ArrayList<ZkClientDetail>();

        if(StringUtils.isBlank(zkHostName)){
            throw new IllegalArgumentException("hostName 不能为空");
        }
        if(StringUtils.isBlank(ZkPort)){
            throw new IllegalArgumentException("port 不能为空");
        }

        try {
            String result = FourLetterWordMain.send4LetterWord(zkHostName,Integer.valueOf(ZkPort),"cons");
            if(!StringUtils.isBlank(result)){
                String[] resultArr = result.split("\n");
                for (String clientInfo : resultArr) {
                    String[] hostAndInfo = clientInfo.split("\\[1\\]");
                    if (hostAndInfo.length == 2) {
                        ZkClientDetail zkClientDetail = new ZkClientDetail();
                        hostName = hostAndInfo[0].split(":")[0].trim().substring(1);
                        port = hostAndInfo[0].split(":")[1];
                        int len_info = hostAndInfo[1].trim().length();
                        String info = hostAndInfo[1].trim().substring(1, len_info - 1);
                        Map<String, String> map = new HashMap<String, String>();

                        for(String infoSplit : info.split(",")){
                            String key = infoSplit.split("=")[0];
                            String value = infoSplit.split("=")[1];
                            map.put(key,value);
                        }

                        send = Long.valueOf(map.get("sent") == null ? "0" : map.get("sent"));
                        received = Long.valueOf(map.get("recved") == null ? "0" : map.get("recved"));
                        Long establishTimeLong = Long.valueOf(map.get("est") == null ? "0" : map.get("est"));
                        establishTime = StringUtil.DateFormat(establishTimeLong);

                        Long lastResponseTimeLong = Long.valueOf(map.get("lresp") == null ? "0" : map.get("lresp"));
                        lastResponseTime = StringUtil.DateFormat(lastResponseTimeLong);
                        maxLatency = Long.valueOf(map.get("maxlat") == null ? "0" : map.get("maxlat"));

                        logger.info(" hostName = " + hostName + " port = " + port + " send = " + send + " received = " + received
                                + " establishTime = " + establishTime + " lastResponseTime = " + lastResponseTime + " maxLatency = " + maxLatency);


                        zkClientDetail.setZkClientDetail(zkClientDetail,hostName, port, send, received, establishTime, lastResponseTime, maxLatency);
                        zkClientDetailList.add(zkClientDetail);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String registerHostName = ZkNodeService.getRegisterHostName();

        return ok(zk_client_detail.render(zkClientDetailList,registerHostName));
    }

    /**
     * 获取注册过的所有ZK集群
     * @return
     */
    public static Result get(){
        final ZkClusterService zkClusterService = ServiceHelper.getZkClusterService();


        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                List<ZkCluster> list = zkClusterService.getZkClusterList();
                if(list != null){
                    for(ZkCluster zkCluster : list){
//                        logger.info("===============SCHEDULE LISTENNING STATUS THREAD===================");
                        Long id = zkCluster.getId();
                        String responseStatus = null;
                        try {
                            responseStatus = FourLetterWordMain.send4LetterWord(zkCluster.getHostName(), Integer.valueOf(zkCluster.getPort()), "ruok");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        responseStatus =  responseStatus == null ? "" : responseStatus.trim();
                        String status = "imok".equals(responseStatus) ? "active" : "dead";
//                        logger.info("=====================[ID=" + id + "]"+" " +"[STATUS=" + status +"]============================");
                        zkClusterService.updateZkClusterStatusById(id,status);
                    }
                }
            }
        },0,10, TimeUnit.SECONDS);

        List<ZkCluster> zkClusterList = zkClusterService.getZkClusterList();
        String registerHostName = ZkNodeService.getRegisterHostName();

        return ok(zk_cluster.render(zkClusterList,registerHostName));
    }

//    public static void main(String[] args) {
//        System.out.println("str".equals(null));
//    }

    /**
     * 注册zk集群
     * @return
     */
    public static Result register(){
        DynamicForm request = Form.form().bindFromRequest();
        String hostName = request.get("hostName");
        String port = request.get("port");
        String description = request.get("description");
        String mode = "";
        Long connections = 0L ;
        Long nodeCount = 0L;
        Long send = 0L ;
        Long received = 0L;
        String status = "";

        if(StringUtils.isBlank(hostName)){
            throw new IllegalArgumentException("hostname 不能为空 + [hostname = " + hostName +"]");
        }

        if(StringUtils.isBlank(port)){
            throw new IllegalArgumentException("port 不能为空 + [port = " + port +"]");
        }

        try {
            String result = FourLetterWordMain.send4LetterWord(hostName,Integer.valueOf(port),"srvr");
            String responseStatus = FourLetterWordMain.send4LetterWord(hostName,Integer.valueOf(port),"ruok");
            responseStatus =  responseStatus == null ? "" : responseStatus.trim();

            if(!StringUtils.isBlank(result)){
                String[] resultArr = result.split("\n");
                mode = resultArr[7].split(":")[1].trim();
                connections = Long.valueOf(resultArr[4].split(":")[1].trim());
                nodeCount = Long.valueOf(resultArr[8].split(":")[1].trim());
                send = Long.valueOf(resultArr[3].split(":")[1].trim());
                received = Long.valueOf(resultArr[2].split(":")[1].trim());
                status = "imok".equals(responseStatus) ? "active" : "dead";
                logger.info("mode = " + mode + " connections = " + connections +" nodeCount = " + nodeCount +" send = " + send + " received = " + received + " status = " + status);
            }
            ZkClusterService zkClusterService = ServiceHelper.getZkClusterService();
//            zkClusterService.insertZkCluster(hostName,port,description,mode,connections,nodeCount,send,received,status);
            zkClusterService.insertZkCluster(hostName,port,description,mode,connections,nodeCount,send,received,status);
        } catch (IOException e) {
            logger.error("Register ZK Error ",e);
        }
        return redirect(routes.ZkClusterAction.get());
    }

    /**
     * 修改zk集群
     */
    public static Result update(){
        DynamicForm request = Form.form().bindFromRequest();
        String idStr = request.get("id");
//        String hostName = request.get("hostName");
//        String port = request.get("port");
        String description = request.get("description");
        Long id = 0L;
        if(idStr == null){
            throw new IllegalArgumentException("===update ZKCluster,Id can not be null; id " +idStr);
        }

        id = Long.valueOf(idStr);
        ZkClusterService zkClusterService = ServiceHelper.getZkClusterService();
//        zkClusterService.updateZkCluster(id,hostName,port,description);
        zkClusterService.updateZkClusterDescById(id,description);
        return redirect(routes.ZkClusterAction.get());
    }

    /**
     * 删除zk集群
     */
    public static Result delete(){
        DynamicForm request = Form.form().bindFromRequest();
        String idStr = request.get("id");
        Long id = 0L;

        if(idStr == null){
            throw new IllegalArgumentException("===delete ZKCluster,Id can not be null; id " +idStr);
        }

        id = Long.valueOf(idStr);
        ZkClusterService zkClusterService = ServiceHelper.getZkClusterService();
        zkClusterService.deleteZkCluster(id);
        return redirect(routes.ZkClusterAction.get());
    }



}
