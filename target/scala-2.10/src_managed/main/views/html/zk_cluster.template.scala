
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
object zk_cluster extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[com.mob.hubble.domain.ZkCluster],String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(zkClusterList:List[com.mob.hubble.domain.ZkCluster],registerHostName:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.79*/("""
<!DOCTYPE html>
<html lang="en">
"""),_display_(Seq[Any](/*4.2*/head("ZK集群信息"))),format.raw/*4.16*/("""
<body>
    <div class="container-fluid">
        """),_display_(Seq[Any](/*7.10*/navbar(registerHostName))),format.raw/*7.34*/("""
        <div style="margin:100px ">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>IP地址</th>
                        <th>端口</th>
                        <th>描述</th>
                        <th>主/从模式</th>
                        <th>连接数</th>
                        <th>节点数</th>
                        <th>发送包(byte)</th>
                        <th>已接收包(byte)</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                """),_display_(Seq[Any](/*25.18*/if(zkClusterList != null)/*25.43*/{_display_(Seq[Any](format.raw/*25.44*/("""
                    """),_display_(Seq[Any](/*26.22*/for(zkCluster <- zkClusterList) yield /*26.53*/{_display_(Seq[Any](format.raw/*26.54*/("""
                        <tr>
                            <td id="zk_hostname">"""),_display_(Seq[Any](/*28.51*/zkCluster/*28.60*/.getHostName)),format.raw/*28.72*/("""</td>
                            <td>"""),_display_(Seq[Any](/*29.34*/zkCluster/*29.43*/.getPort)),format.raw/*29.51*/("""</td>
                            <td>"""),_display_(Seq[Any](/*30.34*/zkCluster/*30.43*/.getDescription)),format.raw/*30.58*/("""</td>
                            <td>"""),_display_(Seq[Any](/*31.34*/zkCluster/*31.43*/.getMode)),format.raw/*31.51*/("""</td>
                            <td>"""),_display_(Seq[Any](/*32.34*/zkCluster/*32.43*/.getConnections)),format.raw/*32.58*/("""</td>
                            <td>"""),_display_(Seq[Any](/*33.34*/zkCluster/*33.43*/.getNodeCount)),format.raw/*33.56*/("""</td>
                            <td>"""),_display_(Seq[Any](/*34.34*/zkCluster/*34.43*/.getSend)),format.raw/*34.51*/("""</td>
                            <td>"""),_display_(Seq[Any](/*35.34*/zkCluster/*35.43*/.getReceived)),format.raw/*35.55*/("""</td>
                            <td>"""),_display_(Seq[Any](/*36.34*/zkCluster/*36.43*/.getStatus)),format.raw/*36.53*/("""</td>
                            <td>
                                <div class="btn-group" role="group">
                                    <button type="button" class="btn btn-default">
                                        <a class="view-btn-a" href=""""),_display_(Seq[Any](/*40.70*/routes/*40.76*/.ZkNodeAction.treeView(zkCluster.getHostName,zkCluster.getPort))),format.raw/*40.139*/("""">集群节点</a>
                                    </button>
                                    <button type="button" id="cluster_update_btn_"""),_display_(Seq[Any](/*42.83*/zkCluster/*42.92*/.getId)),format.raw/*42.98*/("""" cluster_id=""""),_display_(Seq[Any](/*42.113*/zkCluster/*42.122*/.getId)),format.raw/*42.128*/("""" port=""""),_display_(Seq[Any](/*42.137*/zkCluster/*42.146*/.getPort)),format.raw/*42.154*/("""" hostname=""""),_display_(Seq[Any](/*42.167*/zkCluster/*42.176*/.getHostName)),format.raw/*42.188*/("""" description=""""),_display_(Seq[Any](/*42.204*/zkCluster/*42.213*/.getDescription)),format.raw/*42.228*/("""" class="btn btn-default">修改</button>
                                    <button type="button" id="cluster_delete_btn_"""),_display_(Seq[Any](/*43.83*/zkCluster/*43.92*/.getId)),format.raw/*43.98*/("""" data=""""),_display_(Seq[Any](/*43.107*/zkCluster/*43.116*/.getId)),format.raw/*43.122*/("""" class="btn btn-default">删除</button>
                                    <button type="button" class="btn btn-default"><a class="view-btn-a" href=""""),_display_(Seq[Any](/*44.112*/routes/*44.118*/.ZkClusterAction.clientDetail(zkCluster.getHostName,zkCluster.getPort))),format.raw/*44.188*/("""">客户端详情</a></button>
                                </div>
                            </td>
                        </tr>
                    """)))})),format.raw/*48.22*/("""
                """)))})),format.raw/*49.18*/("""
                </tbody>
            </table>
        </div>
    </div>

    """),_display_(Seq[Any](/*55.6*/modal("cluster_delete_modal","删除ZK")/*55.42*/{_display_(Seq[Any](format.raw/*55.43*/("""
        <form method="post" action=""""),_display_(Seq[Any](/*56.38*/routes/*56.44*/.ZkClusterAction.delete())),format.raw/*56.69*/("""">
            是否移除ZK？
            <input type="hidden" name="id" id="delete_id" value="">
            <div class="modal-footer">
                <button class="btn btn-primary" id="delete_comfire" type="submit">确认</button>
                <button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
            </div>
        </form>
    """)))})),format.raw/*64.6*/("""

    """),_display_(Seq[Any](/*66.6*/modal("cluster_update_modal","修改ZK")/*66.42*/{_display_(Seq[Any](format.raw/*66.43*/("""
        <div class="alert alert-danger" role="alert" id="update_cluster_error" style="display:none"></div>
        <form method="post" action=""""),_display_(Seq[Any](/*68.38*/routes/*68.44*/.ZkClusterAction.update())),format.raw/*68.69*/("""" onsubmit="return check_update_cluster()">

            <div class="form-group">
                <label for="hostName">hostName</label>
                <input type="text" class="form-control" id="update_hostname"  autocomplete="off" name="hostName" value="" disabled>
            </div>

            <div class="form-group">
                <label for="port">port</label>
                <input type="text" class="form-control" id="update_port"  autocomplete="off"  name="port" value="" disabled>
            </div>

            <div class="form-group">
                <label for="description">description</label>
                <input type="text" class="form-control" id="update_description"  autocomplete="off" name="description" value="">
            </div>

            <input type="hidden" name="id" autocomplete="off" id="update_id" value="">

            <div class="modal-footer">
                <button class="btn btn-primary" id="delete_comfire" type="submit">确认</button>
                <button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
            </div>
        </form>
    """)))})),format.raw/*92.6*/("""



  <script type="text/javascript">

      function check_update_cluster()"""),format.raw/*98.38*/("""{"""),format.raw/*98.39*/("""
        var port = $("#update_port").val();
        if(port == "") """),format.raw/*100.24*/("""{"""),format.raw/*100.25*/("""
             $("#update_cluster_error").html("port 不能为空");
             $("#update_cluster_error").css("display","block");
             return false;
        """),format.raw/*104.9*/("""}"""),format.raw/*104.10*/("""
        return true;
      """),format.raw/*106.7*/("""}"""),format.raw/*106.8*/("""


      function delete_zk()"""),format.raw/*109.27*/("""{"""),format.raw/*109.28*/("""
        $("[id^=cluster_delete_btn]").click(function()"""),format.raw/*110.55*/("""{"""),format.raw/*110.56*/("""
            $("#cluster_delete_modal").modal('show');
            var id = $(this).attr('data');
            console.log("==== delete id = " + id);
            $("#delete_id").val(id);
        """),format.raw/*115.9*/("""}"""),format.raw/*115.10*/(""");
      """),format.raw/*116.7*/("""}"""),format.raw/*116.8*/("""

      function update_zk()"""),format.raw/*118.27*/("""{"""),format.raw/*118.28*/("""
         $("[id^=cluster_update_btn]").click(function()"""),format.raw/*119.56*/("""{"""),format.raw/*119.57*/("""
            $("#cluster_update_modal").modal('show');
            $("#update_cluster_error").css("display","none");
            var id = $(this).attr("cluster_id");
            var hostName = $(this).attr("hostname");
            var port = $(this).attr("port");
            var description = $(this).attr("description");
            console.log("[update] hostName = " + hostName + " port = " + port + " hostName = " + hostName);

            $("#update_id").val(id);
            $("#update_description").val(description);
            $("#update_port").val(port);
            $("#update_hostname").val(hostName);
        """),format.raw/*132.9*/("""}"""),format.raw/*132.10*/(""");
      """),format.raw/*133.7*/("""}"""),format.raw/*133.8*/("""

      $(document).ready(function()"""),format.raw/*135.35*/("""{"""),format.raw/*135.36*/("""
             delete_zk();

             update_zk();

//             register_zk();
      """),format.raw/*141.7*/("""}"""),format.raw/*141.8*/(""");

  </script>

</body>
</html>"""))}
    }
    
    def render(zkClusterList:List[com.mob.hubble.domain.ZkCluster],registerHostName:String): play.api.templates.HtmlFormat.Appendable = apply(zkClusterList,registerHostName)
    
    def f:((List[com.mob.hubble.domain.ZkCluster],String) => play.api.templates.HtmlFormat.Appendable) = (zkClusterList,registerHostName) => apply(zkClusterList,registerHostName)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Jan 25 18:18:05 CST 2016
                    SOURCE: D:/work/git-repo/tamer/app/views/zk_cluster.scala.html
                    HASH: 573530589dbcfe569affe90780c72d9e02ea1e4e
                    MATRIX: 817->1|988->78|1060->116|1095->130|1184->184|1229->208|1891->834|1925->859|1964->860|2023->883|2070->914|2109->915|2227->997|2245->1006|2279->1018|2355->1058|2373->1067|2403->1075|2479->1115|2497->1124|2534->1139|2610->1179|2628->1188|2658->1196|2734->1236|2752->1245|2789->1260|2865->1300|2883->1309|2918->1322|2994->1362|3012->1371|3042->1379|3118->1419|3136->1428|3170->1440|3246->1480|3264->1489|3296->1499|3596->1763|3611->1769|3697->1832|3874->1973|3892->1982|3920->1988|3972->2003|3991->2012|4020->2018|4066->2027|4085->2036|4116->2044|4166->2057|4185->2066|4220->2078|4273->2094|4292->2103|4330->2118|4487->2239|4505->2248|4533->2254|4579->2263|4598->2272|4627->2278|4814->2428|4830->2434|4923->2504|5104->2653|5155->2672|5275->2757|5320->2793|5359->2794|5434->2833|5449->2839|5496->2864|5893->3230|5937->3239|5982->3275|6021->3276|6204->3423|6219->3429|6266->3454|7441->4598|7551->4680|7580->4681|7679->4751|7709->4752|7900->4915|7930->4916|7988->4946|8017->4947|8078->4979|8108->4980|8193->5036|8223->5037|8450->5236|8480->5237|8518->5247|8547->5248|8606->5278|8636->5279|8722->5336|8752->5337|9415->5972|9445->5973|9483->5983|9512->5984|9579->6022|9609->6023|9734->6120|9763->6121
                    LINES: 26->1|29->1|32->4|32->4|35->7|35->7|53->25|53->25|53->25|54->26|54->26|54->26|56->28|56->28|56->28|57->29|57->29|57->29|58->30|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|61->33|61->33|61->33|62->34|62->34|62->34|63->35|63->35|63->35|64->36|64->36|64->36|68->40|68->40|68->40|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|71->43|71->43|71->43|71->43|71->43|71->43|72->44|72->44|72->44|76->48|77->49|83->55|83->55|83->55|84->56|84->56|84->56|92->64|94->66|94->66|94->66|96->68|96->68|96->68|120->92|126->98|126->98|128->100|128->100|132->104|132->104|134->106|134->106|137->109|137->109|138->110|138->110|143->115|143->115|144->116|144->116|146->118|146->118|147->119|147->119|160->132|160->132|161->133|161->133|163->135|163->135|169->141|169->141
                    -- GENERATED --
                */
            