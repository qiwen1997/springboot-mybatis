package com.newtask.springbootmybatis.entity;

public class item {

  private String itemCode;

  private String itemName;

  private String itemUnit;

  private Integer itemQuantity;

  private double itemStd;

  private double itemAmount;


  public String getItemCode() {
    return itemCode;
  }

  public void setItemCode(String itemCode) {
    this.itemCode = itemCode;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getItemUnit() {
    return itemUnit;
  }

  public void setItemUnit(String itemUnit) {
    this.itemUnit = itemUnit;
  }

  public Integer getItemQuantity() {
    return itemQuantity;
  }

  public void setItemQuantity(Integer itemQuantity) {
    this.itemQuantity = itemQuantity;
  }

  public double getItemStd() {
    return itemStd;
  }

  public void setItemStd(double itemStd) {
    this.itemStd = itemStd;
  }

  public double getItemAmount() {
    return itemAmount;
  }

  public void setItemAmount(double itemAmount) {
    this.itemAmount = itemAmount;
  }

  @Override
  public String toString() {
    return "item{" +
        "itemCode='" + itemCode + '\'' +
        ", itemName='" + itemName + '\'' +
        ", itemUnit='" + itemUnit + '\'' +
        ", itemQuantity=" + itemQuantity +
        ", itemStd=" + itemStd +
        ", itemAmount=" + itemAmount +
        '}';
  }

  public item(String itemCode, String itemName, String itemUnit, Integer itemQuantity,
      double itemStd,
      double itemAmount) {
    this.itemCode = itemCode;
    this.itemName = itemName;
    this.itemUnit = itemUnit;
    this.itemQuantity = itemQuantity;
    this.itemStd = itemStd;
    this.itemAmount = itemAmount;
  }

  public item() {
  }
}
