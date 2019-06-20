package com.newtask.springbootmybatis.entity;

import org.springframework.stereotype.Component;

@Component
public class datas {

  private String fpqqlsh;

  private String statusCode;

  private String statusMsg;

  private data data;

  public com.newtask.springbootmybatis.entity.data getData() {
    return data;
  }

  public void setData(com.newtask.springbootmybatis.entity.data data) {
    this.data = data;
  }

  public String getStatusMsg() {
    return statusMsg;
  }

  public void setStatusMsg(String statusMsg) {
    this.statusMsg = statusMsg;
  }

  public String getFpqqlsh() {
    return fpqqlsh;
  }

  public void setFpqqlsh(String fpqqlsh) {
    this.fpqqlsh = fpqqlsh;
  }

  public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  @Override
  public String toString() {
    return "datas{" +
        "fpqqlsh='" + fpqqlsh + '\'' +
        ", statusCode='" + statusCode + '\'' +
        ", statusMsg='" + statusMsg + '\'' +
        ", data=" + data +
        '}';
  }

  public datas(String fpqqlsh, String statusCode, String statusMsg,
      data data) {
    this.fpqqlsh = fpqqlsh;
    this.statusCode = statusCode;
    this.statusMsg = statusMsg;
    this.data = data;
  }

  public datas() {
  }
}
