package com.sso.vip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class VipController {

    @GetMapping("/index")
    public String toIndex(){
        return "index";
    }
}
