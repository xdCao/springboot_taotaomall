package app.portal.controller;

import app.model.TaoTaoResult;
import app.portal.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.attribute.UserPrincipalLookupService;

/**
 * Created by xdcao on 2017/6/8.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/showLogin")
    public ModelAndView showLogin(){
        return new ModelAndView("portal/login");
    }

    @RequestMapping(value = "/showRegister")
    public ModelAndView showRegister(){
        return new ModelAndView("portal/register");
    }

    @RequestMapping(value = "/check/{username}/1")
    @ResponseBody
    public TaoTaoResult checkUserName(@PathVariable String username){
        return userService.checkUserName(username);
    }

    @RequestMapping(value = "/check/{phone}/2")
    @ResponseBody
    public TaoTaoResult checkPhone(@PathVariable String phone){
        return userService.checkPhone(phone);
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public TaoTaoResult register(@RequestParam String username,@RequestParam String password,@RequestParam String phone){
        return userService.register(username,password,phone);
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public TaoTaoResult login(@RequestParam String username, @RequestParam String password, HttpServletRequest request, HttpServletResponse response){
        return userService.login(username,password,request,response);
    }

    @RequestMapping(value = "/token/{uuid}")
    @ResponseBody
    public TaoTaoResult getSession(@PathVariable String uuid){
        return userService.getSession(uuid);
    }


}
