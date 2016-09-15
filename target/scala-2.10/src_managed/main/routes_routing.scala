// @SOURCE:D:/work/git-repo/tamer/conf/routes
// @HASH:047452b1f75a78248c900f9a1baf6230a030ff7d
// @DATE:Fri Jan 22 18:16:57 CST 2016


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:8
private[this] lazy val controllers_Assets_at0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:9
private[this] lazy val controllers_LoginAction_login1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:10
private[this] lazy val controllers_LoginAction_postLogin2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:13
private[this] lazy val controllers_ZkNodeAction_get3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getNodeData"))))
        

// @LINE:15
private[this] lazy val controllers_ZkNodeAction_delete4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deleteNode"))))
        

// @LINE:16
private[this] lazy val controllers_ZkNodeAction_add5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addNode"))))
        

// @LINE:17
private[this] lazy val controllers_ZkNodeAction_update6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("updateNode"))))
        

// @LINE:19
private[this] lazy val controllers_ZkClusterAction_clientDetail7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("client/detail"))))
        

// @LINE:22
private[this] lazy val controllers_ZkClusterAction_get8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cluster/get"))))
        

// @LINE:23
private[this] lazy val controllers_ZkClusterAction_register9 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cluster/register"))))
        

// @LINE:24
private[this] lazy val controllers_ZkClusterAction_update10 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cluster/update"))))
        

// @LINE:25
private[this] lazy val controllers_ZkClusterAction_delete11 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cluster/delete"))))
        

// @LINE:27
private[this] lazy val controllers_ZkNodeAction_tree12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tree/xml"))))
        

// @LINE:28
private[this] lazy val controllers_ZkNodeAction_treeView13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tree/view"))))
        

// @LINE:29
private[this] lazy val controllers_ZkNodeAction_currentNode14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("currentNode"))))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.LoginAction.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.LoginAction.postLogin()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getNodeData""","""controllers.ZkNodeAction.get()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deleteNode""","""controllers.ZkNodeAction.delete(path:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addNode""","""controllers.ZkNodeAction.add()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """updateNode""","""controllers.ZkNodeAction.update()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """client/detail""","""controllers.ZkClusterAction.clientDetail(zkHostName:String, zkPort:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cluster/get""","""controllers.ZkClusterAction.get()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cluster/register""","""controllers.ZkClusterAction.register()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cluster/update""","""controllers.ZkClusterAction.update()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cluster/delete""","""controllers.ZkClusterAction.delete()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tree/xml""","""controllers.ZkNodeAction.tree()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tree/view""","""controllers.ZkNodeAction.treeView(hostName:String, port:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """currentNode""","""controllers.ZkNodeAction.currentNode()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:8
case controllers_Assets_at0(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:9
case controllers_LoginAction_login1(params) => {
   call { 
        invokeHandler(controllers.LoginAction.login(), HandlerDef(this, "controllers.LoginAction", "login", Nil,"GET", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:10
case controllers_LoginAction_postLogin2(params) => {
   call { 
        invokeHandler(controllers.LoginAction.postLogin(), HandlerDef(this, "controllers.LoginAction", "postLogin", Nil,"POST", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:13
case controllers_ZkNodeAction_get3(params) => {
   call { 
        invokeHandler(controllers.ZkNodeAction.get(), HandlerDef(this, "controllers.ZkNodeAction", "get", Nil,"GET", """""", Routes.prefix + """getNodeData"""))
   }
}
        

// @LINE:15
case controllers_ZkNodeAction_delete4(params) => {
   call(params.fromQuery[String]("path", None)) { (path) =>
        invokeHandler(controllers.ZkNodeAction.delete(path), HandlerDef(this, "controllers.ZkNodeAction", "delete", Seq(classOf[String]),"POST", """""", Routes.prefix + """deleteNode"""))
   }
}
        

// @LINE:16
case controllers_ZkNodeAction_add5(params) => {
   call { 
        invokeHandler(controllers.ZkNodeAction.add(), HandlerDef(this, "controllers.ZkNodeAction", "add", Nil,"POST", """""", Routes.prefix + """addNode"""))
   }
}
        

// @LINE:17
case controllers_ZkNodeAction_update6(params) => {
   call { 
        invokeHandler(controllers.ZkNodeAction.update(), HandlerDef(this, "controllers.ZkNodeAction", "update", Nil,"POST", """""", Routes.prefix + """updateNode"""))
   }
}
        

// @LINE:19
case controllers_ZkClusterAction_clientDetail7(params) => {
   call(params.fromQuery[String]("zkHostName", None), params.fromQuery[String]("zkPort", None)) { (zkHostName, zkPort) =>
        invokeHandler(controllers.ZkClusterAction.clientDetail(zkHostName, zkPort), HandlerDef(this, "controllers.ZkClusterAction", "clientDetail", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """client/detail"""))
   }
}
        

// @LINE:22
case controllers_ZkClusterAction_get8(params) => {
   call { 
        invokeHandler(controllers.ZkClusterAction.get(), HandlerDef(this, "controllers.ZkClusterAction", "get", Nil,"GET", """""", Routes.prefix + """cluster/get"""))
   }
}
        

// @LINE:23
case controllers_ZkClusterAction_register9(params) => {
   call { 
        invokeHandler(controllers.ZkClusterAction.register(), HandlerDef(this, "controllers.ZkClusterAction", "register", Nil,"POST", """""", Routes.prefix + """cluster/register"""))
   }
}
        

// @LINE:24
case controllers_ZkClusterAction_update10(params) => {
   call { 
        invokeHandler(controllers.ZkClusterAction.update(), HandlerDef(this, "controllers.ZkClusterAction", "update", Nil,"POST", """""", Routes.prefix + """cluster/update"""))
   }
}
        

// @LINE:25
case controllers_ZkClusterAction_delete11(params) => {
   call { 
        invokeHandler(controllers.ZkClusterAction.delete(), HandlerDef(this, "controllers.ZkClusterAction", "delete", Nil,"POST", """""", Routes.prefix + """cluster/delete"""))
   }
}
        

// @LINE:27
case controllers_ZkNodeAction_tree12(params) => {
   call { 
        invokeHandler(controllers.ZkNodeAction.tree(), HandlerDef(this, "controllers.ZkNodeAction", "tree", Nil,"GET", """""", Routes.prefix + """tree/xml"""))
   }
}
        

// @LINE:28
case controllers_ZkNodeAction_treeView13(params) => {
   call(params.fromQuery[String]("hostName", None), params.fromQuery[String]("port", None)) { (hostName, port) =>
        invokeHandler(controllers.ZkNodeAction.treeView(hostName, port), HandlerDef(this, "controllers.ZkNodeAction", "treeView", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """tree/view"""))
   }
}
        

// @LINE:29
case controllers_ZkNodeAction_currentNode14(params) => {
   call { 
        invokeHandler(controllers.ZkNodeAction.currentNode(), HandlerDef(this, "controllers.ZkNodeAction", "currentNode", Nil,"GET", """""", Routes.prefix + """currentNode"""))
   }
}
        
}

}
     