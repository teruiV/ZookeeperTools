
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
object navbar extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(registerHostName:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.27*/("""
<div class="navbar  navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <img id="logo" width="50%"  style="height:51px;width:280px" src=""""),_display_(Seq[Any](/*11.73*/routes/*11.79*/.Assets.at("images/banner_zk.png"))),format.raw/*11.113*/("""">
    </div>

"""),format.raw/*14.129*/("""
      <button class="navbar-nav navbar-inverse navbar-brand navbar-left nav-btn" style="margin-left: 0px" id="register_cluster_btn">注册ZK集群</button>
    """),format.raw/*16.182*/("""
      <button class="navbar-nav navbar-inverse navbar-brand navbar-left" style="margin-left: 0px" ><a class="nav-btn" href=""""),_display_(Seq[Any](/*17.126*/routes/*17.132*/.ZkClusterAction.get())),format.raw/*17.154*/("""">集群概况</a></button>

    <div class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">

        <li><a style="color: #999;" href="#">我的设置</a></li>
        <li><a style="color: #999;" href="#">

      </a></li>
        <li><a style="color: #999;" href="#">登出</a></li>
      </ul>
      <form class="navbar-form navbar-right" id="global_search_form">
        <input type="text" class="form-control" placeholder="Search..." id="global_search_input">
      </form>
    </div>
  </div>
</div>
"""),format.raw/*55.3*/("""

"""),_display_(Seq[Any](/*57.2*/modal("cluster_register_modal","注册ZK")/*57.40*/{_display_(Seq[Any](format.raw/*57.41*/("""
    <div class="alert alert-danger" role="alert" id="register_error" style="display:none"></div>
    <form method="post" action=""""),_display_(Seq[Any](/*59.34*/routes/*59.40*/.ZkClusterAction.register())),format.raw/*59.67*/("""" onsubmit="return check_register()">

        <div class="form-group">
            <label for="hostName">HostName<span class="field-detail-tips">注册IP地址如： 192.168.180.78</span></label>
            <input type="text" class="form-control" id="register_hostname"  autocomplete="off" name="hostName" value="">
        </div>

        <div class="form-group">
            <label for="port">Port<span class="field-detail-tips">注册端口如： 2181</span></label>
            <input type="text" class="form-control" id="register_port"  autocomplete="off"  name="port" value="">
        </div>

        <div class="form-group">
            <label for="description">Description<span class="field-detail-tips">ZK集群描述如： 线上ZK集群</span></label>
            <input type="text" class="form-control" id="register_description"  autocomplete="off" name="description" value="">
        </div>

        <div class="modal-footer">
            <button class="btn btn-primary" id="delete_comfire" type="submit">确认</button>
            <button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
        </div>
    </form>
""")))})),format.raw/*81.2*/("""

  <script type="text/javascript">

 $(document).ready(function()"""),format.raw/*85.30*/("""{"""),format.raw/*85.31*/("""
    $("#switch_zk").click(function()"""),format.raw/*86.37*/("""{"""),format.raw/*86.38*/("""
        init_modal();
        $("#switch_zk_modal").modal('show');
    """),format.raw/*89.5*/("""}"""),format.raw/*89.6*/(""");

    register_zk();
 """),format.raw/*92.2*/("""}"""),format.raw/*92.3*/(""");


  function exist_host_name(hostname)"""),format.raw/*95.37*/("""{"""),format.raw/*95.38*/("""
    var register_host_name = """"),_display_(Seq[Any](/*96.32*/registerHostName)),format.raw/*96.48*/("""";
    var exist = false;
    if(register_host_name != "")"""),format.raw/*98.33*/("""{"""),format.raw/*98.34*/("""
        $.each(register_host_name.split(","),function(index,e)"""),format.raw/*99.63*/("""{"""),format.raw/*99.64*/("""
            console.log("e = " + e + "flag = " + (e == hostname));
            if(e == hostname) return exist = true;
        """),format.raw/*102.9*/("""}"""),format.raw/*102.10*/(""");
    """),format.raw/*103.5*/("""}"""),format.raw/*103.6*/("""
    return exist;
  """),format.raw/*105.3*/("""}"""),format.raw/*105.4*/("""

 function check_register()"""),format.raw/*107.27*/("""{"""),format.raw/*107.28*/("""
    var hostname = $("#register_hostname").val() ;
    var port = $("#register_port").val();
    if(hostname == "")"""),format.raw/*110.23*/("""{"""),format.raw/*110.24*/("""
        $("#register_error").html("hostname 不能为空");
        $("#register_error").css("display","block");
        return false;
    """),format.raw/*114.5*/("""}"""),format.raw/*114.6*/("""else if(exist_host_name(hostname))"""),format.raw/*114.40*/("""{"""),format.raw/*114.41*/("""
        $("#register_error").html("hostname已经注册");
        $("#register_error").css("display","block");
        return false;
    """),format.raw/*118.5*/("""}"""),format.raw/*118.6*/("""else if(hostname.split(".").length != 4)"""),format.raw/*118.46*/("""{"""),format.raw/*118.47*/("""
        $("#register_error").html("hostname 格式不正确");
        $("#register_error").css("display","block");
        return false;
    """),format.raw/*122.5*/("""}"""),format.raw/*122.6*/("""

    if(port == "")"""),format.raw/*124.19*/("""{"""),format.raw/*124.20*/("""
        $("#register_error").html("port 不能为空");
        $("#register_error").css("display","block");
        return false;
    """),format.raw/*128.5*/("""}"""),format.raw/*128.6*/("""

    return true;
 """),format.raw/*131.2*/("""}"""),format.raw/*131.3*/("""

     function register_zk()"""),format.raw/*133.28*/("""{"""),format.raw/*133.29*/("""
        $("#register_cluster_btn").click(function()"""),format.raw/*134.52*/("""{"""),format.raw/*134.53*/("""
        $("#cluster_register_modal").modal("show");
        init_cluster_register_modal();
     """),format.raw/*137.6*/("""}"""),format.raw/*137.7*/(""");
     """),format.raw/*138.6*/("""}"""),format.raw/*138.7*/("""

    function init_cluster_register_modal()"""),format.raw/*140.43*/("""{"""),format.raw/*140.44*/("""
           $("#register_hostname").val("");
           $("#register_port").val("");
           $("#register_description").val("");
           $("#register_error").css("display","none");
      """),format.raw/*145.7*/("""}"""),format.raw/*145.8*/("""

   function init_modal()"""),format.raw/*147.25*/("""{"""),format.raw/*147.26*/("""
        $("#hostname").val("");
        $("#port").val("");
        $("#switch_error").css("display","none");
     """),format.raw/*151.6*/("""}"""),format.raw/*151.7*/("""


    function check_input()"""),format.raw/*154.27*/("""{"""),format.raw/*154.28*/("""
               var hostname = $("#hostname").val();
               var port = $("#port").val();

                if(hostname == "") """),format.raw/*158.36*/("""{"""),format.raw/*158.37*/("""
                  $("#switch_error").html("域名不为空")
                  $("#switch_error").css("display","block");
                  return false ;
                """),format.raw/*162.17*/("""}"""),format.raw/*162.18*/("""else if(hostname.split("\.").length != 4)"""),format.raw/*162.59*/("""{"""),format.raw/*162.60*/("""
                  $("#switch_error").html("域名格式错误");
                  $("#switch_error").css("display","block");
                  return false ;
                """),format.raw/*166.17*/("""}"""),format.raw/*166.18*/("""else if(port == "") """),format.raw/*166.38*/("""{"""),format.raw/*166.39*/("""
                  $("#switch_error").html("端口不为空")
                  $("#switch_error").css("display","block");
                  return false;
                """),format.raw/*170.17*/("""}"""),format.raw/*170.18*/("""
                return true;
    """),format.raw/*172.5*/("""}"""),format.raw/*172.6*/("""
  </script>
"""))}
    }
    
    def render(registerHostName:String): play.api.templates.HtmlFormat.Appendable = apply(registerHostName)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (registerHostName) => apply(registerHostName)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Jan 25 12:07:57 CST 2016
                    SOURCE: D:/work/git-repo/tamer/app/views/navbar.scala.html
                    HASH: 567814ce6c6ecd077aaecf2393e9eb494e252497
                    MATRIX: 775->1|894->26|1442->538|1457->544|1514->578|1561->724|1745->1056|1909->1183|1925->1189|1970->1211|2526->2621|2566->2626|2613->2664|2652->2665|2821->2798|2836->2804|2885->2831|4046->3961|4144->4031|4173->4032|4239->4070|4268->4071|4370->4146|4398->4147|4452->4174|4480->4175|4552->4219|4581->4220|4650->4253|4688->4269|4776->4329|4805->4330|4897->4394|4926->4395|5084->4525|5114->4526|5150->4534|5179->4535|5230->4558|5259->4559|5318->4589|5348->4590|5496->4709|5526->4710|5690->4846|5719->4847|5782->4881|5812->4882|5975->5017|6004->5018|6073->5058|6103->5059|6268->5196|6297->5197|6348->5219|6378->5220|6538->5352|6567->5353|6618->5376|6647->5377|6707->5408|6737->5409|6819->5462|6849->5463|6977->5563|7006->5564|7043->5573|7072->5574|7147->5620|7177->5621|7403->5819|7432->5820|7489->5848|7519->5849|7667->5969|7696->5970|7757->6002|7787->6003|7953->6140|7983->6141|8178->6307|8208->6308|8278->6349|8308->6350|8505->6518|8535->6519|8584->6539|8614->6540|8808->6705|8838->6706|8902->6742|8931->6743
                    LINES: 26->1|29->1|39->11|39->11|39->11|42->14|44->16|45->17|45->17|45->17|62->55|64->57|64->57|64->57|66->59|66->59|66->59|88->81|92->85|92->85|93->86|93->86|96->89|96->89|99->92|99->92|102->95|102->95|103->96|103->96|105->98|105->98|106->99|106->99|109->102|109->102|110->103|110->103|112->105|112->105|114->107|114->107|117->110|117->110|121->114|121->114|121->114|121->114|125->118|125->118|125->118|125->118|129->122|129->122|131->124|131->124|135->128|135->128|138->131|138->131|140->133|140->133|141->134|141->134|144->137|144->137|145->138|145->138|147->140|147->140|152->145|152->145|154->147|154->147|158->151|158->151|161->154|161->154|165->158|165->158|169->162|169->162|169->162|169->162|173->166|173->166|173->166|173->166|177->170|177->170|179->172|179->172
                    -- GENERATED --
                */
            