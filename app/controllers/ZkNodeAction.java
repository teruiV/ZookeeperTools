package controllers;


import com.mob.hubble.domain.ZkCluster;
import com.mob.hubble.service.ZkClusterService;
import domain.ZkNodeInfo;
import org.apache.log4j.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import service.ZkNodeService;
import utils.ServiceHelper;
import views.html.*;

import java.util.List;


/**
 * Created by jianwl on 2016/1/12.
 */
public class ZkNodeAction extends Controller {
    private static final Logger logger = Logger.getLogger(ZkNodeAction.class);


//    public static Result getTreeView(){
//        response().setContentType("xml");
//        String result = CuratorService.readXML("/");
//        return  ok(result);
//    }
    /**
     * 显示当前集群
     * @return
     */
    public static Result currentNode(){
        String zkAddress = ZkNodeService.getCurrentZkAddress();
        ZkClusterService zkClusterService = ServiceHelper.getZkClusterService();
        List<ZkCluster> zkClusterList =  zkClusterService.getZkClusterList();
        String hostName = "";
        String port = "";

        if(zkAddress == null) {
            if(zkClusterList != null && zkClusterList.size() >= 1){
                hostName = zkClusterList.get(0).getHostName();
                port = zkClusterList.get(0).getPort();
            }
        } else if(zkAddress != null  && zkAddress.split(":").length == 2){
            hostName = zkAddress.split(":")[0];
            port = zkAddress.split(":")[1];
        }

        String regiterHostName = ZkNodeService.getRegisterHostName();
        logger.info("===[currentNode] = hostname = " + hostName + "port = " + port + " zkAddress " + zkAddress);
        return ok(side_tree.render(hostName,port,regiterHostName));
    }

    /**
     * 返回构造树形结构的xml
     * @return
     */

    public static Result tree(){
        DynamicForm request = Form.form().bindFromRequest();
        String hostName = request.get("hostName");
        String port = request.get("port");
        String tree = ZkNodeService.readXML(hostName,port);
        response().setContentType("xml");
        return ok(tree);
    }

    /**
     * 创建Curator Client，展示ZK的树形view
     * @param hostName
     * @param port
     * @return
     */
    public static Result treeView(String hostName,String port){
        String registerHostName = ZkNodeService.getRegisterHostName();
        return ok(side_tree.render(hostName,port,registerHostName));
    }
    /**
     * 获取ZK路径上的节点信息
     * @return
     */
    public static Result get(){
        DynamicForm request = Form.form().bindFromRequest();
        String path = request.get("path");
        ZkNodeInfo zkNodeInfo = ZkNodeService.getZkNodeData(path);
        String allChildPath = ZkNodeService.getChildPathByPath(path);

        return ok(zk_node_info.render(zkNodeInfo,allChildPath));
    }

    /**
     * 删除ZK节点
     * @param path
     * @return
     */
    public static Result delete(String path){
        ZkNodeService.deleteZkNode(path);
        return ok();
    }

    /**
     * 添加ZK节点
     * @return
     */
    public static Result add(){
        DynamicForm request = Form.form().bindFromRequest();
        String parentPath = request.get("parentPath");
        String childPath = request.get("childPath");
        String data = request.get("data");
        logger.info( "ip:port = " +parentPath+":"+childPath  +" data = " + data);
        ZkNodeService.addZkNode(parentPath, childPath, data);
        return ok();
    }


    /**
     * 更新ZK节点
     * @return
     */
    public static Result update(){
        DynamicForm request = Form.form().bindFromRequest();
        String path = request.get("path");
        String data = request.get("data");
        logger.info("== path = " + path + "data = " + data);
        ZkNodeService.updateZkNode(path, data);
        ZkNodeInfo zkNodeInfo = ZkNodeService.getZkNodeData(path);
        String allChildPath = ZkNodeService.getChildPathByPath(path);

        return ok(zk_node_info.render(zkNodeInfo,allChildPath));
    }





}
