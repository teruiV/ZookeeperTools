package controllers;

import play.mvc.Controller;

import play.mvc.Result;
import views.html.*;

/**
 * Created by jianwl on 2016/1/13.
 */
public class LoginAction extends Controller {
    public static Result login(){
        return ok(login.render());
    }

    public static Result postLogin(){
        return redirect(routes.ZkNodeAction.currentNode());
    }
}
