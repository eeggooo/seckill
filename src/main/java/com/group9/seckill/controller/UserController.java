package com.group9.seckill.controller;

import com.group9.seckill.entity.UserInfo;
import com.group9.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/register")
    public String register( UserInfo userInfo){
        boolean result=userService.insertUserInfo(userInfo);
        return result?"redirect:/login":"redirect:/register";
    }
    @PostMapping("/login")
    public String login(UserInfo userInfo, HttpSession session){
        UserInfo userInfo1 = userService.selectUserNameAndPassword(userInfo);

        if(userInfo1!=null){
            session.setAttribute("userInfo",userInfo1);
            return "redirect:/index.html";
        }
        else{
            return "redirect:/login";
        }
    }
}
