package com.newtask.springbootmybatis.entity;

public class bill {

  private String code;

  private String msg;

  private datas datas;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public com.newtask.springbootmybatis.entity.datas getDatas() {
    return datas;
  }

  public void setDatas(com.newtask.springbootmybatis.entity.datas datas) {
    this.datas = datas;
  }

  @Override
  public String toString() {
    return "bill{" +
        "code='" + code + '\'' +
        ", msg='" + msg + '\'' +
        ", datas=" + datas +
        '}';
  }
}
