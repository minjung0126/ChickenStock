package com.chicken.project.release.model.dto;

import java.sql.Date;

public class StoreOrderDTO {

    private int orderNo;
    private java.sql.Date orderDate;
    private int orderAmount;
    private int cartNo;
    private int itemNo;
    private String storeName;
    private String relYn;

    public StoreOrderDTO() {}

    public StoreOrderDTO(int orderNo, Date orderDate, int orderAmount, int cartNo, int itemNo, String storeName, String relYn) {
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.cartNo = cartNo;
        this.itemNo = itemNo;
        this.storeName = storeName;
        this.relYn = relYn;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public int getCartNo() {
        return cartNo;
    }

    public void setCartNo(int cartNo) {
        this.cartNo = cartNo;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getRelYn() {
        return relYn;
    }

    public void setRelYn(String relYn) {
        this.relYn = relYn;
    }

    @Override
    public String toString() {
        return "StoreOrderDTO{" +
                "orderNo=" + orderNo +
                ", orderDate=" + orderDate +
                ", orderAmount=" + orderAmount +
                ", cartNo=" + cartNo +
                ", itemNo=" + itemNo +
                ", storeName='" + storeName + '\'' +
                ", relYn='" + relYn + '\'' +
                '}';
    }
}
