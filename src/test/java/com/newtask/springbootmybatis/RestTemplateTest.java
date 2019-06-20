package com.newtask.springbootmybatis;

import com.newtask.springbootmybatis.entity.Fpqqlsh;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@Controller
public class RestTemplateTest {

//  private Logger logger= LoggerFactory.getLogger(SpringbootMybatisApplicationTests.class);
//  @Test
//  @RequestMapping("/test")
//  @ResponseBody
//  public void test(){
//    HttpServletRequest request;
//    InputStream io = null;
//    String body;
//    System.out.println("------- body -------");
//    try{
//      io = request.getInputStream();
//      body = IOUtils.toString(io);
//      //打印BODY内容
//      System.out.println("Request Body="+body);
//    }catch(IOException e){
//      e.printStackTrace();
//    }
//
//
//  }
}
