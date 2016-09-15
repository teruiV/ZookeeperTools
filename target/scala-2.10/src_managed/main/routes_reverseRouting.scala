// @SOURCE:D:/work/git-repo/tamer/conf/routes
// @HASH:047452b1f75a78248c900f9a1baf6230a030ff7d
// @DATE:Fri Jan 22 18:16:57 CST 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:8
package controllers {

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
class ReverseZkNodeAction {
    

// @LINE:28
def treeView(hostName:String, port:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "tree/view" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("hostName", hostName)), Some(implicitly[QueryStringBindable[String]].unbind("port", port)))))
}
                                                

// @LINE:16
def add(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "addNode")
}
                                                

// @LINE:13
def get(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getNodeData")
}
                                                

// @LINE:15
def delete(path:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "deleteNode" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("path", path)))))
}
                                                

// @LINE:27
def tree(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "tree/xml")
}
                                                

// @LINE:17
def update(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "updateNode")
}
                                                

// @LINE:29
def currentNode(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "currentNode")
}
                                                
    
}
                          

// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:19
class ReverseZkClusterAction {
    

// @LINE:25
def delete(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "cluster/delete")
}
                                                

// @LINE:19
def clientDetail(zkHostName:String, zkPort:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "client/detail" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("zkHostName", zkHostName)), Some(implicitly[QueryStringBindable[String]].unbind("zkPort", zkPort)))))
}
                                                

// @LINE:22
def get(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cluster/get")
}
                                                

// @LINE:23
def register(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "cluster/register")
}
                                                

// @LINE:24
def update(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "cluster/update")
}
                                                
    
}
                          

// @LINE:8
class ReverseAssets {
    

// @LINE:8
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:10
// @LINE:9
class ReverseLoginAction {
    

// @LINE:10
def postLogin(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                                                

// @LINE:9
def login(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                                                
    
}
                          
}
                  


// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:8
package controllers.javascript {

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
class ReverseZkNodeAction {
    

// @LINE:28
def treeView : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ZkNodeAction.treeView",
   """
      function(hostName,port) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tree/view" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("hostName", hostName), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("port", port)])})
      }
   """
)
                        

// @LINE:16
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ZkNodeAction.add",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addNode"})
      }
   """
)
                        

// @LINE:13
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ZkNodeAction.get",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getNodeData"})
      }
   """
)
                        

// @LINE:15
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ZkNodeAction.delete",
   """
      function(path) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteNode" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("path", path)])})
      }
   """
)
                        

// @LINE:27
def tree : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ZkNodeAction.tree",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tree/xml"})
      }
   """
)
                        

// @LINE:17
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ZkNodeAction.update",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateNode"})
      }
   """
)
                        

// @LINE:29
def currentNode : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ZkNodeAction.currentNode",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "currentNode"})
      }
   """
)
                        
    
}
              

// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:19
class ReverseZkClusterAction {
    

// @LINE:25
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ZkClusterAction.delete",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cluster/delete"})
      }
   """
)
                        

// @LINE:19
def clientDetail : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ZkClusterAction.clientDetail",
   """
      function(zkHostName,zkPort) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "client/detail" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("zkHostName", zkHostName), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("zkPort", zkPort)])})
      }
   """
)
                        

// @LINE:22
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ZkClusterAction.get",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cluster/get"})
      }
   """
)
                        

// @LINE:23
def register : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ZkClusterAction.register",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cluster/register"})
      }
   """
)
                        

// @LINE:24
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ZkClusterAction.update",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cluster/update"})
      }
   """
)
                        
    
}
              

// @LINE:8
class ReverseAssets {
    

// @LINE:8
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:10
// @LINE:9
class ReverseLoginAction {
    

// @LINE:10
def postLogin : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.LoginAction.postLogin",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:9
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.LoginAction.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:8
package controllers.ref {


// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
class ReverseZkNodeAction {
    

// @LINE:28
def treeView(hostName:String, port:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ZkNodeAction.treeView(hostName, port), HandlerDef(this, "controllers.ZkNodeAction", "treeView", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """tree/view""")
)
                      

// @LINE:16
def add(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ZkNodeAction.add(), HandlerDef(this, "controllers.ZkNodeAction", "add", Seq(), "POST", """""", _prefix + """addNode""")
)
                      

// @LINE:13
def get(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ZkNodeAction.get(), HandlerDef(this, "controllers.ZkNodeAction", "get", Seq(), "GET", """""", _prefix + """getNodeData""")
)
                      

// @LINE:15
def delete(path:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ZkNodeAction.delete(path), HandlerDef(this, "controllers.ZkNodeAction", "delete", Seq(classOf[String]), "POST", """""", _prefix + """deleteNode""")
)
                      

// @LINE:27
def tree(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ZkNodeAction.tree(), HandlerDef(this, "controllers.ZkNodeAction", "tree", Seq(), "GET", """""", _prefix + """tree/xml""")
)
                      

// @LINE:17
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ZkNodeAction.update(), HandlerDef(this, "controllers.ZkNodeAction", "update", Seq(), "POST", """""", _prefix + """updateNode""")
)
                      

// @LINE:29
def currentNode(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ZkNodeAction.currentNode(), HandlerDef(this, "controllers.ZkNodeAction", "currentNode", Seq(), "GET", """""", _prefix + """currentNode""")
)
                      
    
}
                          

// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:19
class ReverseZkClusterAction {
    

// @LINE:25
def delete(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ZkClusterAction.delete(), HandlerDef(this, "controllers.ZkClusterAction", "delete", Seq(), "POST", """""", _prefix + """cluster/delete""")
)
                      

// @LINE:19
def clientDetail(zkHostName:String, zkPort:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ZkClusterAction.clientDetail(zkHostName, zkPort), HandlerDef(this, "controllers.ZkClusterAction", "clientDetail", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """client/detail""")
)
                      

// @LINE:22
def get(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ZkClusterAction.get(), HandlerDef(this, "controllers.ZkClusterAction", "get", Seq(), "GET", """""", _prefix + """cluster/get""")
)
                      

// @LINE:23
def register(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ZkClusterAction.register(), HandlerDef(this, "controllers.ZkClusterAction", "register", Seq(), "POST", """""", _prefix + """cluster/register""")
)
                      

// @LINE:24
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ZkClusterAction.update(), HandlerDef(this, "controllers.ZkClusterAction", "update", Seq(), "POST", """""", _prefix + """cluster/update""")
)
                      
    
}
                          

// @LINE:8
class ReverseAssets {
    

// @LINE:8
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:10
// @LINE:9
class ReverseLoginAction {
    

// @LINE:10
def postLogin(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.LoginAction.postLogin(), HandlerDef(this, "controllers.LoginAction", "postLogin", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:9
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.LoginAction.login(), HandlerDef(this, "controllers.LoginAction", "login", Seq(), "GET", """""", _prefix + """login""")
)
                      
    
}
                          
}
        
    