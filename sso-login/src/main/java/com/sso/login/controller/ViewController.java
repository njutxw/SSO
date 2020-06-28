package com.sso.login.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

//页面跳转逻辑
@Controller
@RequestMapping("/view")
public class ViewController {

    //跳转到登录页面
    @GetMapping("/login")
    public String toLogin(@RequestParam(required = false,defaultValue = "") String target,
                          HttpSession session){
        if(!StringUtils.isEmpty(target)){
            target = "http://www.codeshop.com:9010";
        }
        session.setAttribute("target",target);
        return "login";
    }
}
