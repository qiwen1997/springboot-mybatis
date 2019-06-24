package com.newtask.springbootmybatis.exception;

import com.newtask.springbootmybatis.entity.bill;
import com.newtask.springbootmybatis.entity.datas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(annotations = Controller.class)
@ResponseBody
public class ControllerExceptionHandler {


  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus
  public bill handerI(IllegalArgumentException e){
    bill bill=new bill();
    bill.setCode("1001");
    bill.setMsg("查询失败,数据不合法");
    return bill;
  }

  @ExceptionHandler
  @ResponseStatus
  public bill handerE(Exception e){
    bill bill=new bill();
    bill.setCode("9999");
    bill.setMsg("查询失败，未知错误");
    return bill;
  }

}
