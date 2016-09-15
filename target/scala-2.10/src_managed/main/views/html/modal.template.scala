
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
object modal extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,String,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(modal_id: String,modal_title: String)(content:Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.54*/("""		
		<div class="modal fade" id=""""),_display_(Seq[Any](/*2.32*/modal_id)),format.raw/*2.40*/("""">
			<div class="modal-dialog ">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">"""),_display_(Seq[Any](/*10.32*/modal_title)),format.raw/*10.43*/("""</h4>
					</div>
		
					<div class="modal-body">
							"""),_display_(Seq[Any](/*14.9*/content)),format.raw/*14.16*/("""	
					</div>
				</div>
			</div>
		</div>"""))}
    }
    
    def render(modal_id:String,modal_title:String,content:Html): play.api.templates.HtmlFormat.Appendable = apply(modal_id,modal_title)(content)
    
    def f:((String,String) => (Html) => play.api.templates.HtmlFormat.Appendable) = (modal_id,modal_title) => (content) => apply(modal_id,modal_title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jan 22 16:08:21 CST 2016
                    SOURCE: D:/work/git-repo/tamer/app/views/modal.scala.html
                    HASH: eee2545fd33ec2e5e65f91ed3302d776d17682e1
                    MATRIX: 786->1|932->53|1002->88|1031->96|1357->386|1390->397|1488->460|1517->467
                    LINES: 26->1|29->1|30->2|30->2|38->10|38->10|42->14|42->14
                    -- GENERATED --
                */
            