
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
object head extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.16*/("""

<head>
  <meta charset="UTF-8">
  <title>"""),_display_(Seq[Any](/*5.11*/title)),format.raw/*5.16*/("""</title>

  <!-- CSS -->
  <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.48*/routes/*8.54*/.Assets.at("stylesheets/main.css"))),format.raw/*8.88*/("""">
  <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*9.48*/routes/*9.54*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*9.97*/("""">
  <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*10.48*/routes/*10.54*/.Assets.at("javascripts/dhtmlx_std_full/dhtmlx.css"))),format.raw/*10.106*/("""">
  <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*11.53*/routes/*11.59*/.Assets.at("images/shortcut.png"))),format.raw/*11.92*/("""">


    <!-- JavaScript -->
  <script src=""""),_display_(Seq[Any](/*15.17*/routes/*15.23*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*15.68*/("""" type="text/javascript"></script>
  <script src=""""),_display_(Seq[Any](/*16.17*/routes/*16.23*/.Assets.at("javascripts/bootstrap/js/bootstrap.min.js"))),format.raw/*16.78*/("""" type="text/javascript"></script>
  <script src=""""),_display_(Seq[Any](/*17.17*/routes/*17.23*/.Assets.at("javascripts/dhtmlx_std_full/dhtmlx.js"))),format.raw/*17.74*/("""" type="text/javascript"></script>

</head>
"""))}
    }
    
    def render(title:String): play.api.templates.HtmlFormat.Appendable = apply(title)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (title) => apply(title)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jan 22 16:08:20 CST 2016
                    SOURCE: D:/work/git-repo/tamer/app/views/head.scala.html
                    HASH: 39308d3b63102076453458d4f9603949f1baf786
                    MATRIX: 773->1|881->15|964->63|990->68|1100->143|1114->149|1169->183|1255->234|1269->240|1333->283|1420->334|1435->340|1510->392|1602->448|1617->454|1672->487|1757->536|1772->542|1839->587|1927->639|1942->645|2019->700|2107->752|2122->758|2195->809
                    LINES: 26->1|29->1|33->5|33->5|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17
                    -- GENERATED --
                */
            