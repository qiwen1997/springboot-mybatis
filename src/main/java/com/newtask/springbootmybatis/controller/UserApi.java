package com.newtask.springbootmybatis.controller;

import com.alibaba.fastjson.JSONObject;
import com.newtask.springbootmybatis.entity.user;
import com.newtask.springbootmybatis.mapper.userDao;
import com.newtask.springbootmybatis.service.TokenService;

import com.newtask.springbootmybatis.target.UserLoginToken;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class UserApi {
  @Resource
  userDao userService;
  @Autowired
  TokenService tokenService;
  //登录
  @RequestMapping("/login")
  public Object login(HttpServletRequest request, HttpServletResponse response,Model model){
    JSONObject jsonObject=new JSONObject();
    user userForBase=userService.findUserById(Integer.parseInt(request.getParameter("id")));
    if(userForBase==null){
      jsonObject.put("message","登录失败,用户不存在");
      return jsonObject;
    }else {
      if (!userForBase.getPassword().equals(request.getParameter("password"))){
        jsonObject.put("message","登录失败,密码错误");
        return jsonObject;
      }else {
        String token = tokenService.getToken(userForBase);
        jsonObject.put("token", token);
        jsonObject.put("user", userForBase);
        Cookie cookie=new Cookie("token",token);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(3600);
        cookie.setDomain("localhost");
        cookie.setPath("/");
        response.addCookie(cookie);
        return jsonObject;
      }
    }
  }
  @UserLoginToken
  @RequestMapping("/getMessage")
  public String getMessage(){
    return "你已通过验证";
  }

  @RequestMapping("/fail")
  public String fail(){
    return "签名验权失败";
  }
}
