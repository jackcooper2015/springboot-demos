package com.reapal.controller;

import com.reapal.domain.User;
import com.reapal.exception.MyException;
import com.reapal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by 10400 on 2017/1/10.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(ModelMap modelMap, HttpServletRequest request){
        modelMap.put("base",request.getContextPath());
        return "index";
    }


    @RequestMapping("/testException")
    public String testException(ModelMap modelMap, HttpServletRequest request)throws Exception{
       throw new Exception();
    }

    @RequestMapping("/testMyException")
    public String testMyException(ModelMap modelMap, HttpServletRequest request)throws MyException{
        throw new MyException("测试自定义异常");
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(ModelMap modelMap, HttpServletRequest request){
        modelMap.put("base",request.getContextPath());
        return "login";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(ModelMap modelMap, HttpServletRequest request){
        modelMap.put("base",request.getContextPath());
        return "register";
    }

    @RequestMapping(value = "/signin",method = RequestMethod.POST)
    public String signin(ModelMap modelMap, HttpServletRequest request,User user , RedirectAttributes redirectAttributes){
        User u = userService.login(user.getName(), user.getPassword());
        if(null == u){
            redirectAttributes.addFlashAttribute("message","");
            return "redirect:/testMyException";
        }
        redirectAttributes.addFlashAttribute("message","登录成功");
        return "redirect:/index";
    }

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public String signup(ModelMap modelMap, HttpServletRequest request, User user, RedirectAttributes redirectAttributes){
        User u = userService.regiset(user);
        redirectAttributes.addFlashAttribute("message","注册成功");
        return "redirect:/index";
    }

}
