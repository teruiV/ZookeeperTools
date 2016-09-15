
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
object zk_node_info extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[domain.ZkNodeInfo,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(zkNodeInfo:domain.ZkNodeInfo,allChildPath : String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.54*/("""
<html>
  """),_display_(Seq[Any](/*3.4*/head("nodeInfo"))),format.raw/*3.20*/("""
<style>
    .btn_init"""),format.raw/*5.14*/("""{"""),format.raw/*5.15*/("""
        margin:0px;
        padding: 0px;
    """),format.raw/*8.5*/("""}"""),format.raw/*8.6*/("""
</style>
<body>

  <div class="alert alert-danger" role="alert" id="path" style="display:none"></div>
  <div style="margin-top:20px ">
      <div class="btn-group" role="group" style="margin: 10px">
          <button  class="btn btn-default" id="add_btn"><span class="glyphicon glyphicon-plus"></span>添加节点</button>
          <button  class="btn btn-default" id="delete_btn"><span class="glyphicon glyphicon-trash"></span>删除节点</button>
          <button  class="btn btn-default" id="update_btn"><span class="glyphicon glyphicon-wrench"></span>修改节点</button>
      </div>

      <div style="margin: 10px">
        <table class="table table-bordered">
        """),_display_(Seq[Any](/*22.10*/if(zkNodeInfo != null)/*22.32*/ {_display_(Seq[Any](format.raw/*22.34*/("""
          <tr>
            <th>path</th>
            <td>"""),_display_(Seq[Any](/*25.18*/zkNodeInfo/*25.28*/.getPath)),format.raw/*25.36*/("""</td>
          </tr>
          <tr>
            <th>data</th>
            <td>"""),_display_(Seq[Any](/*29.18*/zkNodeInfo/*29.28*/.getData)),format.raw/*29.36*/("""</td>
          </tr>
          <tr>
            <th>czxid</th>
            <td>"""),_display_(Seq[Any](/*33.18*/zkNodeInfo/*33.28*/.getCzxid)),format.raw/*33.37*/("""</td>
          </tr>
          <tr>
            <th>ctime</th>
            <td>"""),_display_(Seq[Any](/*37.18*/zkNodeInfo/*37.28*/.getCtime)),format.raw/*37.37*/("""</td>
          </tr>
          <tr>
            <th>version</th>
            <td>"""),_display_(Seq[Any](/*41.18*/zkNodeInfo/*41.28*/.getVersion)),format.raw/*41.39*/("""</td>
          </tr>
          <tr>
            <th>cversion</th>
            <td>"""),_display_(Seq[Any](/*45.18*/zkNodeInfo/*45.28*/.getCversion)),format.raw/*45.40*/("""</td>
          </tr>
          <tr>
            <th>aversion</th>
            <td>"""),_display_(Seq[Any](/*49.18*/zkNodeInfo/*49.28*/.getAversion)),format.raw/*49.40*/("""</td>
          </tr>
          <tr>
            <th>ephemeralOwner</th>
            <td>"""),_display_(Seq[Any](/*53.18*/zkNodeInfo/*53.28*/.getEphemeralOwner)),format.raw/*53.46*/("""</td>
          </tr>
          <tr>
            <th>dataLength</th>
            <td>"""),_display_(Seq[Any](/*57.18*/zkNodeInfo/*57.28*/.getDataLength)),format.raw/*57.42*/("""</td>
          </tr>
          <tr>
            <th>numChildren</th>
            <td>"""),_display_(Seq[Any](/*61.18*/zkNodeInfo/*61.28*/.getNumChildren)),format.raw/*61.43*/("""</td>
          </tr>
          <tr>
            <th>pzxid</th>
            <td>"""),_display_(Seq[Any](/*65.18*/zkNodeInfo/*65.28*/.getPzxid)),format.raw/*65.37*/("""</td>
          </tr>
        """)))})),format.raw/*67.10*/("""
        </table>
      </div>
  </div>

  """),_display_(Seq[Any](/*72.4*/modal("delete_modal",zkNodeInfo.getPath)/*72.44*/{_display_(Seq[Any](format.raw/*72.45*/("""
    <form method="post" action=""""),_display_(Seq[Any](/*73.34*/routes/*73.40*/.ZkNodeAction.delete(zkNodeInfo.getPath))),format.raw/*73.80*/("""">
      是否删除此节点？
      <div class="modal-footer">
        <button class="btn btn-primary" id="delete_comfire" type="submit">确认</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
      </div>
    </form>
  """)))})),format.raw/*80.4*/("""

  """),_display_(Seq[Any](/*82.4*/modal("add_modal",zkNodeInfo.getPath)/*82.41*/{_display_(Seq[Any](format.raw/*82.42*/("""
    <form method="post" action=""""),_display_(Seq[Any](/*83.34*/routes/*83.40*/.ZkNodeAction.add())),format.raw/*83.59*/("""" onsubmit="return check_add_modal()">
      <div class="alert alert-danger" role="alert" id="add_error" style="display:none"></div>
      <div class="form-group">
        <label for="parentPath">parentPath</label>
          """),_display_(Seq[Any](/*87.12*/if( zkNodeInfo.getPath == "/")/*87.42*/{_display_(Seq[Any](format.raw/*87.43*/("""
            <input type="hidden" class="form-control" name="parentPath" value=""""),_display_(Seq[Any](/*88.81*/{zkNodeInfo.getPath})),format.raw/*88.101*/("""">
            <input type="text" class="form-control" name="parentPath" value=""""),_display_(Seq[Any](/*89.79*/{zkNodeInfo.getPath})),format.raw/*89.99*/("""" disabled>
          """)))}/*90.13*/else/*90.17*/{_display_(Seq[Any](format.raw/*90.18*/("""
          <input type="hidden" class="form-control" name="parentPath" value=""""),_display_(Seq[Any](/*91.79*/{zkNodeInfo.getPath})),format.raw/*91.99*/("""/">
          <input type="text" class="form-control" name="parentPath" value=""""),_display_(Seq[Any](/*92.77*/{zkNodeInfo.getPath})),format.raw/*92.97*/("""/" disabled>
          """)))})),format.raw/*93.12*/("""
      </div>

      <div class="form-group">
        <label for="childPath">childPath</label>
        <input type="text" class="form-control"  name="childPath" autocomplete="off" id="childPath" value="">
      </div>

      <div class="form-group">
        <label for="data">data</label>
        <textarea type="text" class="form-control" autocomplete="off" name="data" id="add_data"></textarea>
      </div>


      <div class="modal-footer">
        <button class="btn btn-primary" id="add_comfire" type="submit">确认</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
      </div>
    </form>
  """)))})),format.raw/*112.4*/("""

  """),_display_(Seq[Any](/*114.4*/modal("update_modal",zkNodeInfo.getPath)/*114.44*/{_display_(Seq[Any](format.raw/*114.45*/("""
    <form method="post" action=""""),_display_(Seq[Any](/*115.34*/routes/*115.40*/.ZkNodeAction.update())),format.raw/*115.62*/("""">
      <div class="form-group">
        <label for="path">path</label>
        <input type="hidden" class="form-control" name="path" value=""""),_display_(Seq[Any](/*118.71*/{zkNodeInfo.getPath})),format.raw/*118.91*/("""/">
        <input type="text" class="form-control" name="path" value=""""),_display_(Seq[Any](/*119.69*/{zkNodeInfo.getPath})),format.raw/*119.89*/("""" disabled>
      </div>

      <div class="form-group">
        <label for="data">data</label>
        <textarea type="text" class="form-control"  rows="5" cols="20"name="data" autocomplete="off" id="update_data"></textarea>
      </div>

      <div class="modal-footer">
        <button class="btn btn-primary"  type="submit">确认</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
      </div>
    </form>
  """)))})),format.raw/*132.4*/("""


  </body>

<script type="text/javascript">
      $(document).ready(function()"""),format.raw/*138.35*/("""{"""),format.raw/*138.36*/("""
        var path = """"),_display_(Seq[Any](/*139.22*/zkNodeInfo/*139.32*/.getPath)),format.raw/*139.40*/("""";


        $("#delete_btn").click(function()"""),format.raw/*142.42*/("""{"""),format.raw/*142.43*/("""

             if(path == "/")"""),format.raw/*144.29*/("""{"""),format.raw/*144.30*/("""
//               alert("根路径不能删除" + path);
               $("#path").css("display","block");
               $("#path").html("根路径不能删除");
               return;
            """),format.raw/*149.13*/("""}"""),format.raw/*149.14*/("""else if(path.indexOf("/zookeeper") != -1)"""),format.raw/*149.55*/("""{"""),format.raw/*149.56*/("""
//               alert("zookeeper目录下的节点不能删除" + path );
              $("#path").css("display","block");
              $("#path").html("zookeeper目录下的节点不能删除");
               return;
            """),format.raw/*154.13*/("""}"""),format.raw/*154.14*/("""

            $("#delete_modal").modal('show');
            $("#delete_comfire").click(function()"""),format.raw/*157.50*/("""{"""),format.raw/*157.51*/("""
                parent.location.reload();
             """),format.raw/*159.14*/("""}"""),format.raw/*159.15*/(""");
        """),format.raw/*160.9*/("""}"""),format.raw/*160.10*/(""");

        $("#add_btn").click(function()"""),format.raw/*162.39*/("""{"""),format.raw/*162.40*/("""

            if(path.indexOf("/zookeeper") != -1)"""),format.raw/*164.49*/("""{"""),format.raw/*164.50*/("""
               //alert("不能增加zookeeper目录下的节点" + path );
               $("#path").css("display","block");
               $("#path").html("不能增加zookeeper目录下的节点");
               return;
            """),format.raw/*169.13*/("""}"""),format.raw/*169.14*/("""

            add_modal_init();

            $("#add_modal").modal('show');
             $("#add_comfire").click(function()"""),format.raw/*174.48*/("""{"""),format.raw/*174.49*/("""
               if(check_add_modal())"""),format.raw/*175.37*/("""{"""),format.raw/*175.38*/("""
                parent.location.reload();
               """),format.raw/*177.16*/("""}"""),format.raw/*177.17*/("""
          """),format.raw/*178.11*/("""}"""),format.raw/*178.12*/(""");
        """),format.raw/*179.9*/("""}"""),format.raw/*179.10*/(""");

        $("#update_btn").click(function()"""),format.raw/*181.42*/("""{"""),format.raw/*181.43*/("""

            if(path == "/")"""),format.raw/*183.28*/("""{"""),format.raw/*183.29*/("""
               //alert("根路径不能修改" + path)
               $("#path").css("display","block");
               $("#path").html("根路径不能修改");
               return;
            """),format.raw/*188.13*/("""}"""),format.raw/*188.14*/("""else if(path.indexOf("/zookeeper") != -1)"""),format.raw/*188.55*/("""{"""),format.raw/*188.56*/("""
               //alert("zookeeper目录下的节点不能修改" + path );
                $("#path").css("display","block");
                $("#path").html("zookeeper目录下的节点不能修改");
               return;
            """),format.raw/*193.13*/("""}"""),format.raw/*193.14*/("""
            updata_modal_init();
            $("#update_modal").modal('show');
        """),format.raw/*196.9*/("""}"""),format.raw/*196.10*/(""");
      """),format.raw/*197.7*/("""}"""),format.raw/*197.8*/(""");

      function add_modal_init()"""),format.raw/*199.32*/("""{"""),format.raw/*199.33*/("""
        $("#childPath").val("");
        $("#add_data").val("");
        $("#add_error").css('display','none');
      """),format.raw/*203.7*/("""}"""),format.raw/*203.8*/("""

      function updata_modal_init()"""),format.raw/*205.35*/("""{"""),format.raw/*205.36*/("""
        var data = """"),_display_(Seq[Any](/*206.22*/zkNodeInfo/*206.32*/.getData)),format.raw/*206.40*/("""";
        //转换引号转义字符
        data = data.replace(/&quot;/g,"\"");

        $("#update_data").val(data);

        $("#add_error").css('display','none');
//        console.log("data = " +$("#update_data").val());
      """),format.raw/*214.7*/("""}"""),format.raw/*214.8*/("""

      function exist_new_node(childPath)"""),format.raw/*216.41*/("""{"""),format.raw/*216.42*/("""

        var allChildPath = """"),_display_(Seq[Any](/*218.30*/allChildPath)),format.raw/*218.42*/("""";
        console.log("allChildPath = " + allChildPath);
        var exist = false;
        if(allChildPath != "")"""),format.raw/*221.31*/("""{"""),format.raw/*221.32*/("""
          $.each(allChildPath.split(","),function(index,e)"""),format.raw/*222.59*/("""{"""),format.raw/*222.60*/("""
               if(childPath == e) return exist = true;
          """),format.raw/*224.11*/("""}"""),format.raw/*224.12*/(""");
        """),format.raw/*225.9*/("""}"""),format.raw/*225.10*/("""
        return exist ? true : false;
      """),format.raw/*227.7*/("""}"""),format.raw/*227.8*/("""

      function check_add_modal()"""),format.raw/*229.33*/("""{"""),format.raw/*229.34*/("""
         var childPath = $("#childPath").val();
//         console.log("childPath = " + childPath);
//         console.log("childPath = " + (childPath == ""));
//         console.log(childPath.charAt(childPath.trim().length-1) =="/");
         if(childPath == "")"""),format.raw/*234.29*/("""{"""),format.raw/*234.30*/("""
            $("#add_error").html("新节点路径不能为空");
            $("#add_error").css('display','block');
            return false;
         """),format.raw/*238.10*/("""}"""),format.raw/*238.11*/("""else if(childPath.charAt(childPath.trim().length-1) =="/")"""),format.raw/*238.69*/("""{"""),format.raw/*238.70*/("""
            $("#add_error").html("新路径不能以/结尾");
            $("#add_error").css('display','block');
            return false;
         """),format.raw/*242.10*/("""}"""),format.raw/*242.11*/("""else if(exist_new_node(childPath))"""),format.raw/*242.45*/("""{"""),format.raw/*242.46*/("""
            $("#add_error").html("新节点已经存在,不能重复添加");
            $("#add_error").css('display','block');
            return false;
         """),format.raw/*246.10*/("""}"""),format.raw/*246.11*/("""
         return true;
      """),format.raw/*248.7*/("""}"""),format.raw/*248.8*/("""
  </script>

</html>



"""))}
    }
    
    def render(zkNodeInfo:domain.ZkNodeInfo,allChildPath:String): play.api.templates.HtmlFormat.Appendable = apply(zkNodeInfo,allChildPath)
    
    def f:((domain.ZkNodeInfo,String) => play.api.templates.HtmlFormat.Appendable) = (zkNodeInfo,allChildPath) => apply(zkNodeInfo,allChildPath)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Jan 25 18:26:00 CST 2016
                    SOURCE: D:/work/git-repo/tamer/app/views/zk_node_info.scala.html
                    HASH: e47940b81d02725c48ccc2833d8cf08c331b8099
                    MATRIX: 799->1|945->53|992->66|1029->82|1080->106|1108->107|1184->157|1211->158|1919->830|1950->852|1990->854|2088->916|2107->926|2137->934|2257->1018|2276->1028|2306->1036|2427->1121|2446->1131|2477->1140|2598->1225|2617->1235|2648->1244|2771->1331|2790->1341|2823->1352|2947->1440|2966->1450|3000->1462|3124->1550|3143->1560|3177->1572|3307->1666|3326->1676|3366->1694|3492->1784|3511->1794|3547->1808|3674->1899|3693->1909|3730->1924|3851->2009|3870->2019|3901->2028|3966->2061|4050->2110|4099->2150|4138->2151|4209->2186|4224->2192|4286->2232|4575->2490|4617->2497|4663->2534|4702->2535|4773->2570|4788->2576|4829->2595|5095->2825|5134->2855|5173->2856|5291->2938|5334->2958|5452->3040|5494->3060|5537->3085|5550->3089|5589->3090|5705->3170|5747->3190|5864->3271|5906->3291|5963->3316|6656->3977|6699->3984|6749->4024|6789->4025|6861->4060|6877->4066|6922->4088|7105->4234|7148->4254|7258->4327|7301->4347|7800->4814|7915->4900|7945->4901|8005->4924|8025->4934|8056->4942|8134->4991|8164->4992|8225->5024|8255->5025|8460->5201|8490->5202|8560->5243|8590->5244|8818->5443|8848->5444|8977->5544|9007->5545|9094->5603|9124->5604|9164->5616|9194->5617|9267->5661|9297->5662|9378->5714|9408->5715|9638->5916|9668->5917|9825->6045|9855->6046|9922->6084|9952->6085|10041->6145|10071->6146|10112->6158|10142->6159|10182->6171|10212->6172|10288->6219|10318->6220|10378->6251|10408->6252|10612->6427|10642->6428|10712->6469|10742->6470|10974->6673|11004->6674|11123->6765|11153->6766|11191->6776|11220->6777|11286->6814|11316->6815|11467->6938|11496->6939|11563->6977|11593->6978|11653->7001|11673->7011|11704->7019|11958->7245|11987->7246|12060->7290|12090->7291|12160->7324|12195->7336|12342->7454|12372->7455|12461->7515|12491->7516|12588->7584|12618->7585|12658->7597|12688->7598|12762->7644|12791->7645|12856->7681|12886->7682|13184->7951|13214->7952|13382->8091|13412->8092|13499->8150|13529->8151|13697->8290|13727->8291|13790->8325|13820->8326|13993->8470|14023->8471|14082->8502|14111->8503
                    LINES: 26->1|29->1|31->3|31->3|33->5|33->5|36->8|36->8|50->22|50->22|50->22|53->25|53->25|53->25|57->29|57->29|57->29|61->33|61->33|61->33|65->37|65->37|65->37|69->41|69->41|69->41|73->45|73->45|73->45|77->49|77->49|77->49|81->53|81->53|81->53|85->57|85->57|85->57|89->61|89->61|89->61|93->65|93->65|93->65|95->67|100->72|100->72|100->72|101->73|101->73|101->73|108->80|110->82|110->82|110->82|111->83|111->83|111->83|115->87|115->87|115->87|116->88|116->88|117->89|117->89|118->90|118->90|118->90|119->91|119->91|120->92|120->92|121->93|140->112|142->114|142->114|142->114|143->115|143->115|143->115|146->118|146->118|147->119|147->119|160->132|166->138|166->138|167->139|167->139|167->139|170->142|170->142|172->144|172->144|177->149|177->149|177->149|177->149|182->154|182->154|185->157|185->157|187->159|187->159|188->160|188->160|190->162|190->162|192->164|192->164|197->169|197->169|202->174|202->174|203->175|203->175|205->177|205->177|206->178|206->178|207->179|207->179|209->181|209->181|211->183|211->183|216->188|216->188|216->188|216->188|221->193|221->193|224->196|224->196|225->197|225->197|227->199|227->199|231->203|231->203|233->205|233->205|234->206|234->206|234->206|242->214|242->214|244->216|244->216|246->218|246->218|249->221|249->221|250->222|250->222|252->224|252->224|253->225|253->225|255->227|255->227|257->229|257->229|262->234|262->234|266->238|266->238|266->238|266->238|270->242|270->242|270->242|270->242|274->246|274->246|276->248|276->248
                    -- GENERATED --
                */
            