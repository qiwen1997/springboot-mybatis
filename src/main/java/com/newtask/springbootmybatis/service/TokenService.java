package com.newtask.springbootmybatis.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.newtask.springbootmybatis.entity.user;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TokenService {

  public String getToken(user user) {
    String token="";
    token= JWT.create().withAudience(String.valueOf(user.getId()))
        .sign(Algorithm.HMAC256(user.getPassword()));
    return token;
  }
}
