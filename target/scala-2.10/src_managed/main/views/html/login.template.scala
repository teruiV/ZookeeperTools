
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
object login extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<html>
    """),_display_(Seq[Any](/*2.6*/head("login"))),format.raw/*2.19*/("""
    <body>
        <div id="main_content" class="col-md-6 col-md-offset-4 main">
            <div class="row">
                <div class="container col-md-10 table-bordered img-rounded" style="padding:50px;box-shadow: 0 10px 25px rgba(0,0,0,0.5);">
                    <div class="row">
                        <div class="col-md-12">
                            <form role="form" action=""""),_display_(Seq[Any](/*9.56*/routes/*9.62*/.LoginAction.login())),format.raw/*9.82*/("""" method="POST">
                                <legend>ZK监控系统登录</legend>
                                <div class="form-group">
                                    <label for="admin_username">帐号</label>
                                    <input type="email" name="username" class="form-control" id="admin_username" placeholder="Enter your email account" value="">
                                </div>
                                <div class="form-group">
                                    <label for="admin_password">密码</label>
                                    <input type="password"  name="password" class="form-control" id="admin_password" placeholder="Password">
                                </div>
                                <button type="submit" class="btn btn-primary btn-default">Submit</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>


"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jan 22 16:08:20 CST 2016
                    SOURCE: D:/work/git-repo/tamer/app/views/login.scala.html
                    HASH: c739725b8616ed50c5a90ca60decf0978fa64d36
                    MATRIX: 855->0|901->12|935->25|1362->417|1376->423|1417->443
                    LINES: 29->1|30->2|30->2|37->9|37->9|37->9
                    -- GENERATED --
                */
            