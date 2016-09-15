
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object side_tree extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(hostName:String,port:String,registerHostName:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.55*/("""
<!DOCTYPE html>
<html lang="en">
"""),_display_(Seq[Any](/*4.2*/head("treeView"))),format.raw/*4.18*/("""
<style>
.index_content """),format.raw/*6.16*/("""{"""),format.raw/*6.17*/("""
position: relative;
margin-top: 60px;
margin-left: 0px;
width:1800px;
height:800px;
"""),format.raw/*12.1*/("""}"""),format.raw/*12.2*/("""
</style>
<body>
  <div class="container-fluid">
  """),_display_(Seq[Any](/*16.4*/navbar(registerHostName))),format.raw/*16.28*/("""
  <div id="index_content" class="index_content">
      <div class="alert alert-danger" role="alert" id="tree_error" style="display:none"></div>
      <div id="tree_struct" style="width:100%;height:100%"></div>
  </div>
  </div>

<script type="text/javascript">
       $(document).ready(function()"""),format.raw/*24.36*/("""{"""),format.raw/*24.37*/("""
            var hostName = """"),_display_(Seq[Any](/*25.30*/hostName)),format.raw/*25.38*/("""";
            var port = """"),_display_(Seq[Any](/*26.26*/port)),format.raw/*26.30*/("""";
            console.log("[side tree]  hostName = " + hostName + " port = " + port);
            console.log(hostName != "" && port != "");

            if(hostName != "" && port !="") """),format.raw/*30.45*/("""{"""),format.raw/*30.46*/("""
                var myLayout = new dhtmlXLayoutObject("index_content", "2U");
                var myTree = new dhtmlXTreeObject("tree_struct","100%","100%",0);
                myTree.setImagePath("../assets/javascripts/dhtmlx_std_full/imgs/dhxtree_skyblue/");
                myTree.enableSmartXMLParsing(true);
                var url = "/tree/xml?hostName="""),_display_(Seq[Any](/*35.48*/{hostName})),format.raw/*35.58*/("""&port="""),_display_(Seq[Any](/*35.65*/{port})),format.raw/*35.71*/("""";
                console.log("[tree url] url = " + url);
                myTree.load(url);
//                myTree._xcloseAll("0");
//                myTree._HideShow(0,1);
//                myTree.openAllItems();


                var zk_address = hostName + ":" + port;
                myLayout.cells("a").setText("zk节点列表 \t\t" + zk_address);
                myLayout.cells("a").setWidth(500);
                myLayout.cells("a").attachObject("tree_struct");
                myLayout.cells("b").setText("节点信息");
                myTree.setOnClickHandler(getNodeData);

                function getNodeData(id)"""),format.raw/*50.41*/("""{"""),format.raw/*50.42*/("""
                    //console.log("id = " + id);
                    myLayout.cells("b").attachURL("../getNodeData?path="+id);
                """),format.raw/*53.17*/("""}"""),format.raw/*53.18*/("""
            """),format.raw/*54.13*/("""}"""),format.raw/*54.14*/("""else """),format.raw/*54.19*/("""{"""),format.raw/*54.20*/("""
                  console.log("eeee");
                  $("#tree_error").html("请先注册ZK集群");
                  $("#tree_error").css("display","block");
            """),format.raw/*58.13*/("""}"""),format.raw/*58.14*/("""
         """),format.raw/*59.10*/("""}"""),format.raw/*59.11*/(""");
  </script>
</body>
</html>"""))}
    }
    
    def render(hostName:String,port:String,registerHostName:String): play.api.templates.HtmlFormat.Appendable = apply(hostName,port,registerHostName)
    
    def f:((String,String,String) => play.api.templates.HtmlFormat.Appendable) = (hostName,port,registerHostName) => apply(hostName,port,registerHostName)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jan 22 16:08:21 CST 2016
                    SOURCE: D:/work/git-repo/tamer/app/views/side_tree.scala.html
                    HASH: d2fdd32f4efaa56a1cf90788998059e01f1721cb
                    MATRIX: 792->1|939->54|1011->92|1048->108|1101->134|1129->135|1247->226|1275->227|1366->283|1412->307|1745->612|1774->613|1841->644|1871->652|1936->681|1962->685|2181->876|2210->877|2611->1242|2643->1252|2686->1259|2714->1265|3370->1893|3399->1894|3574->2041|3603->2042|3645->2056|3674->2057|3707->2062|3736->2063|3932->2231|3961->2232|4000->2243|4029->2244
                    LINES: 26->1|29->1|32->4|32->4|34->6|34->6|40->12|40->12|44->16|44->16|52->24|52->24|53->25|53->25|54->26|54->26|58->30|58->30|63->35|63->35|63->35|63->35|78->50|78->50|81->53|81->53|82->54|82->54|82->54|82->54|86->58|86->58|87->59|87->59
                    -- GENERATED --
                */
            