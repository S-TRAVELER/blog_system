package com.blog.controller;

import com.blog.model.User;
import com.blog.redis.StringRedisServiceImpl;
import com.blog.service.UserService;
import com.blog.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: blanche
 * @Date: 2019/11/4 11:48
 * Describe:
 */
@Controller
public class RegisterControl {

    @Autowired
    UserService userService;
    @Autowired
    StringRedisServiceImpl stringRedisService;

    @PostMapping("/register")
    @ResponseBody
    public String register(User user,
                            HttpServletRequest request){

        String authCode = request.getParameter("authCode");

        String trueMsgCode = (String) stringRedisService.get(user.getPhone());

        //判断手机号是否正确
        if(trueMsgCode == null){
            return "5";
        }
        //判断验证码是否正确
        if(!authCode.equals(trueMsgCode)){
            return "0";
        }
        //判断用户名是否存在
        if(userService.usernameIsExist(user.getUsername())){
            return "3";
        }
        //注册时对密码进行MD5加密
        MD5Util md5Util = new MD5Util();
        user.setPassword(md5Util.encode(user.getPassword()));
        return userService.insert(user);
    }

}
