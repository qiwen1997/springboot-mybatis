package com.newtask.springbootmybatis.entity;

import java.util.List;

public class data {

  private String einvoiceCode;

  private String einvoiceNumber;

  private String randomNumber;

  private String issueDate;

  private double totalAmount;

  private String handlingPerson;

  private String payerPartyName;

  private List<item> items;

  public String getEinvoiceCode() {
    return einvoiceCode;
  }

  public void setEinvoiceCode(String einvoiceCode) {
    this.einvoiceCode = einvoiceCode;
  }

  public String getEinvoiceNumber() {
    return einvoiceNumber;
  }

  public void setEinvoiceNumber(String einvoiceNumber) {
    this.einvoiceNumber = einvoiceNumber;
  }

  public String getRandomNumber() {
    return randomNumber;
  }

  public void setRandomNumber(String randomNumber) {
    this.randomNumber = randomNumber;
  }

  public String getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(String issueDate) {
    this.issueDate = issueDate;
  }

  public double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public String getHandlingPerson() {
    return handlingPerson;
  }

  public void setHandlingPerson(String handlingPerson) {
    this.handlingPerson = handlingPerson;
  }

  public String getPayerPartyName() {
    return payerPartyName;
  }

  public void setPayerPartyName(String payerPartyName) {
    this.payerPartyName = payerPartyName;
  }

  public List<item> getItems() {
    return items;
  }

  public void setItems(List<item> items) {
    this.items = items;
  }

  @Override
  public String toString() {
    return "data{" +
        "einvoiceCode='" + einvoiceCode + '\'' +
        ", einvoiceNumber='" + einvoiceNumber + '\'' +
        ", randomNumber='" + randomNumber + '\'' +
        ", issueDate='" + issueDate + '\'' +
        ", totalAmount=" + totalAmount +
        ", handlingPerson='" + handlingPerson + '\'' +
        ", payerPartyName='" + payerPartyName + '\'' +
        ", items=" + items +
        '}';
  }

  public data(String einvoiceCode, String einvoiceNumber, String randomNumber,
     double totalAmount, String handlingPerson, String payerPartyName,
      List<item> items) {
    this.einvoiceCode = einvoiceCode;
    this.einvoiceNumber = einvoiceNumber;
    this.randomNumber = randomNumber;

    this.totalAmount = totalAmount;
    this.handlingPerson = handlingPerson;
    this.payerPartyName = payerPartyName;
    this.items = items;
  }

  public data() {
  }
}
