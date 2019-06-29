package com.group9.seckill.controller;

import com.group9.seckill.entity.UserInfo;
import com.group9.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/user")
public class CheckController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/check_username")
    @ResponseBody
    public boolean checkName(String UserName) {

        return userService.checkUserName(UserName);
    }
}
