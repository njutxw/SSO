package com.sso.login.controller;

import com.sso.login.pojo.User;
import com.sso.login.utils.LoginCacheUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Controller
@RequestMapping("/login")
public class LoginController {

    private static Set<User> dbUsers;
    static{
        dbUsers = new HashSet<>();
        dbUsers.add(new User(0,"zhangsan","123456"));
        dbUsers.add(new User(1,"lisi","1234567"));
        dbUsers.add(new User(2,"wangwu","123"));
    }

    @PostMapping()
    public String doLogin(User user,HttpSession session){
        String target = (String) session.getAttribute("target");

        Optional<User> first = dbUsers.stream().filter(users -> users.getUsername().equals(user.getUsername()) &&
                users.getPassword().equals(user.getPassword())).findFirst();
        if(first.isPresent()){
            String token = UUID.randomUUID().toString();
            LoginCacheUtil.loginUser.put(token,first.get());
        }else{
            session.setAttribute("msg","用户名或密码错误");
            return "login";
        }
        //重定向到target地址
        return "redirect"+target;
    }

}
