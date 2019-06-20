package com.newtask.springbootmybatis.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.newtask.springbootmybatis.entity.Fpqqlsh;
import com.newtask.springbootmybatis.entity.bill;
import com.newtask.springbootmybatis.entity.datas;
import com.newtask.springbootmybatis.mapper.dataDao;
import com.newtask.springbootmybatis.mapper.datasDao;
import com.newtask.springbootmybatis.target.UserLoginToken;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jfunc.json.JsonObject;

@Controller
@UserLoginToken
@RequestMapping("/practice/invoice")
public class BillController {

  @Resource
  private datasDao datasDao;

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Autowired
  private bill bill;

  @Autowired
  private datas datas;

  private RedisTemplate<String, String> redisCacheTemplate;

  @UserLoginToken
  @RequestMapping("/query")
  @ResponseBody
  public bill select(HttpServletRequest request, Model model){
    String fpqqlsh=new String();
    fpqqlsh=httpFpqqlsh(request);
    System.out.println("fpqqlsh="+fpqqlsh);

    if(fpqqlsh.equals("null")){
      bill.setCode("1001");
      bill.setMsg("查询失败,数据不合法");
      return bill;
    }

    bill billx=JSONObject.parseObject(stringRedisTemplate.opsForValue().get("practice:invoice:"+fpqqlsh),
          com.newtask.springbootmybatis.entity.bill.class);

    if (billx!=null){
      billx.setMsg("缓存查询成功");
      return billx;
    }
      datas = datasDao.selectByFpqqlsh(fpqqlsh);


    if(datas==null){
      bill.setCode("1002");
      bill.setMsg("查询失败，数据不存在");
      return bill;
    }else if(datas.getStatusCode().equals("4")){
      return setBill(datas,"开票完成",fpqqlsh);
    }else if(datas.getStatusCode().equals("3")){
      return setBill(datas,"开票失败",fpqqlsh);
    }else{
      return setBill(datas,"开票中",fpqqlsh);
    }

  }

  public bill setBill(datas datas,String StatusCode,String fpqqlsh){
    bill.setCode("0000");
    bill.setMsg("查询成功");
    datas.setStatusCode(StatusCode);
    bill.setDatas(datas);
    stringRedisTemplate.opsForValue().set("practice:invoice:"+fpqqlsh, JSONObject.toJSONString(bill),10*60,
        TimeUnit.SECONDS);
    return bill;
  }

  public String httpFpqqlsh(HttpServletRequest request){
    InputStream io = null;
    String body=new String();
    System.out.println("------- body -------");
    try{
      io = request.getInputStream();
      body = IOUtils.toString(io);
      //打印BODY内容
    }catch(IOException e){
      e.printStackTrace();
    }
    Fpqqlsh fpqqlsh = JSONObject.parseObject(body, Fpqqlsh.class);
    return fpqqlsh.getFpqqlsh();
  }

}