package com.newtask.springbootmybatis.controller;




import com.alibaba.fastjson.JSONObject;
import com.newtask.springbootmybatis.entity.Fpqqlsh;
import com.newtask.springbootmybatis.entity.user;
import com.newtask.springbootmybatis.mapper.userDao;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/CURD")
public class CURD {
  @Resource
  private userDao userDao;

  @RequestMapping("/delete")
  public String delete(int id) {
    int result = userDao.delete(id);
    if (result >= 1) {
      return "删除成功";
    } else {
      return "删除失败";
    }
  }

  @RequestMapping("/update")
  public String update(user user) {
    int result = userDao.Update(user);
    if (result >= 1) {
      return "修改成功";
    } else {
      return "修改失败";
    }

  }

  @RequestMapping("/insert")
  public int insert(user user) {
    return userDao.insertUser(user);
  }

  @RequestMapping("/listuser")
  @ResponseBody
  public List<user> ListUser(){
    return userDao.ListUser();
  }

  @RequestMapping("/listuserbyname")
  @ResponseBody
  public List<user> ListUserByname(String name){
    return userDao.findUserByName(name);
  }

  @RequestMapping("/test")
  @ResponseBody
  public String test(HttpServletRequest request){
    InputStream io = null;
    String body=new String();
    System.out.println("------- body -------");
    try{
      io = request.getInputStream();
      body = IOUtils.toString(io);
      //打印BODY内容
      System.out.println("Request Body="+body);
    }catch(IOException e){
      e.printStackTrace();
    }
    Fpqqlsh fpqqlsh = JSONObject.parseObject(body, Fpqqlsh.class);
    System.out.println(fpqqlsh.getFpqqlsh());
    return body;
  }

}