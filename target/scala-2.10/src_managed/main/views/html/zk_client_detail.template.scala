
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
object zk_client_detail extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[domain.ZkClientDetail],String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(zkClientDetailList:List[domain.ZkClientDetail],registerHostName:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.74*/("""
<!DOCTYPE html>
<html lang="en">
    """),_display_(Seq[Any](/*4.6*/head("Client Detail"))),format.raw/*4.27*/("""
    private String hostName;
    private String port;
    private Long send;
    private Long received;
    private Long establishTime;
    private Long lastResponseTime;
    private Long maxLatency;
<body>
    <div class="container-fluid">
        """),_display_(Seq[Any](/*14.10*/navbar(registerHostName))),format.raw/*14.34*/("""
        <div style="margin:100px ">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>客户端IP地址</th>
                        <th>端口</th>
                        <th>发送包(byte)</th>
                        <th>已接收包(byte)</th>
                        <th>创建时间</th>
                        <th>最后响应时间</th>
                        <th>最大延时(ms)</th>
                    </tr>
                </thead>
                <tbody>
                """),_display_(Seq[Any](/*29.18*/if(zkClientDetailList != null)/*29.48*/{_display_(Seq[Any](format.raw/*29.49*/("""
                    """),_display_(Seq[Any](/*30.22*/for(zkClientDetail <- zkClientDetailList) yield /*30.63*/{_display_(Seq[Any](format.raw/*30.64*/("""
                        <tr>
                            <td id="client_hostname">"""),_display_(Seq[Any](/*32.55*/zkClientDetail/*32.69*/.getHostName)),format.raw/*32.81*/("""</td>
                            <td>"""),_display_(Seq[Any](/*33.34*/zkClientDetail/*33.48*/.getPort)),format.raw/*33.56*/("""</td>
                            <td>"""),_display_(Seq[Any](/*34.34*/zkClientDetail/*34.48*/.getSend)),format.raw/*34.56*/("""</td>
                            <td>"""),_display_(Seq[Any](/*35.34*/zkClientDetail/*35.48*/.getReceived)),format.raw/*35.60*/("""</td>
                            <td>"""),_display_(Seq[Any](/*36.34*/zkClientDetail/*36.48*/.getEstablishTime)),format.raw/*36.65*/("""</td>
                            <td>"""),_display_(Seq[Any](/*37.34*/zkClientDetail/*37.48*/.getLastResponseTime)),format.raw/*37.68*/("""</td>
                            <td>"""),_display_(Seq[Any](/*38.34*/zkClientDetail/*38.48*/.getMaxLatency)),format.raw/*38.62*/("""</td>
                        </tr>
                    """)))})),format.raw/*40.22*/("""
                """)))})),format.raw/*41.18*/("""
                </tbody>
            </table>
    <div class="alert alert-danger" role="alert" id="client_detail_error" style="display:none"></div>
    </div>
    </div>

    <script type="text/javascript">
        $(document).ready(function()"""),format.raw/*49.37*/("""{"""),format.raw/*49.38*/("""
           var client_hostname_length= $("[id^=client_hostname]").length;
           console.log("client_hostname_length = " + client_hostname_length);
           if(client_hostname_length == 0)"""),format.raw/*52.43*/("""{"""),format.raw/*52.44*/("""
                $("#client_detail_error").html("没有连接该ZK集群的客户端");
                $("#client_detail_error").css("display","block");
           """),format.raw/*55.12*/("""}"""),format.raw/*55.13*/("""
        """),format.raw/*56.9*/("""}"""),format.raw/*56.10*/(""");
    </script>

</body>
</html>"""))}
    }
    
    def render(zkClientDetailList:List[domain.ZkClientDetail],registerHostName:String): play.api.templates.HtmlFormat.Appendable = apply(zkClientDetailList,registerHostName)
    
    def f:((List[domain.ZkClientDetail],String) => play.api.templates.HtmlFormat.Appendable) = (zkClientDetailList,registerHostName) => apply(zkClientDetailList,registerHostName)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Jan 25 18:18:44 CST 2016
                    SOURCE: D:/work/git-repo/tamer/app/views/zk_client_detail.scala.html
                    HASH: b51be4ffe269885823db8a8989a00f50542abaca
                    MATRIX: 813->1|979->73|1052->112|1094->133|1381->384|1427->408|1973->918|2012->948|2051->949|2109->971|2166->1012|2205->1013|2325->1097|2348->1111|2382->1123|2457->1162|2480->1176|2510->1184|2585->1223|2608->1237|2638->1245|2713->1284|2736->1298|2770->1310|2845->1349|2868->1363|2907->1380|2982->1419|3005->1433|3047->1453|3122->1492|3145->1506|3181->1520|3270->1577|3320->1595|3592->1839|3621->1840|3844->2035|3873->2036|4044->2179|4073->2180|4109->2189|4138->2190
                    LINES: 26->1|29->1|32->4|32->4|42->14|42->14|57->29|57->29|57->29|58->30|58->30|58->30|60->32|60->32|60->32|61->33|61->33|61->33|62->34|62->34|62->34|63->35|63->35|63->35|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|68->40|69->41|77->49|77->49|80->52|80->52|83->55|83->55|84->56|84->56
                    -- GENERATED --
                */
            