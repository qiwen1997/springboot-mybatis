package com.newtask.springbootmybatis.Interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.newtask.springbootmybatis.entity.user;
import com.newtask.springbootmybatis.mapper.userDao;
import com.newtask.springbootmybatis.target.PassToken;
import com.newtask.springbootmybatis.target.UserLoginToken;
import java.lang.reflect.Method;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthenticationInterceptor implements HandlerInterceptor {

  @Resource
  userDao userService;

  @Override
  public boolean preHandle(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, Object object) throws Exception {

    Cookie[] cookies = httpServletRequest.getCookies();
    String token =null;
    if(cookies!=null) {
      for (Cookie cookie : cookies) {
        if ("token".equals(cookie.getName())) {
          token = cookie.getValue();
        }
      }
    }
     token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
    // 如果不是映射到方法直接通过
    if (!(object instanceof HandlerMethod)) {
      return true;
    }
    HandlerMethod handlerMethod = (HandlerMethod) object;
    Method method = handlerMethod.getMethod();
    //检查是否有passtoken注释，有则跳过认证
    if (method.isAnnotationPresent(PassToken.class)) {
      PassToken passToken = method.getAnnotation(PassToken.class);
      if (passToken.required()) {
        return true;
      }
    }
    //检查有没有需要用户权限的注解
    if (method.isAnnotationPresent(UserLoginToken.class)) {
      UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
      if (userLoginToken.required()) {
        // 执行认证
        if (token == null) {
          httpServletResponse.sendRedirect("/api/fail");
          return false;
          //throw new RuntimeException("无token，请重新登录");
        }
        // 获取 token 中的 user id
        String userId;
        try {
          userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
          httpServletResponse.sendRedirect("/api/fail");
          return false;
        }
        user user = userService.findUserById(Integer.parseInt(userId));
        if (user == null) {
          throw new RuntimeException("用户不存在，请重新登录");
        }
        // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
          jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
          throw new RuntimeException("401");
        }
        return true;
      }
    }
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      Object o, ModelAndView modelAndView) throws Exception {

  }

  @Override
  public void afterCompletion(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      Object o, Exception e) throws Exception {
  }


}
