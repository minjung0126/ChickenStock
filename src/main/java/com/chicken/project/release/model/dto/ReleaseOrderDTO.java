package com.chicken.project.release.model.dto;

import java.sql.Date;

public class ReleaseOrderDTO {

    private int orderNo;
    private java.sql.Date orderDate;
    private int orderAmount;
    private int cartNo;
    private int itemNo;
    private String storeName;
    private ItemInfoDTO itemInfoDTO;
    private ItemCategoryDTO itemCategoryDTO;

    public ReleaseOrderDTO() {}

    public ReleaseOrderDTO(int orderNo, Date orderDate, int orderAmount, int cartNo, int itemNo, String storeName, ItemInfoDTO itemInfoDTO, ItemCategoryDTO itemCategoryDTO) {
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.cartNo = cartNo;
        this.itemNo = itemNo;
        this.storeName = storeName;
        this.itemInfoDTO = itemInfoDTO;
        this.itemCategoryDTO = itemCategoryDTO;
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

    public ItemInfoDTO getItemInfoDTO() {
        return itemInfoDTO;
    }

    public void setItemInfoDTO(ItemInfoDTO itemInfoDTO) {
        this.itemInfoDTO = itemInfoDTO;
    }

    public ItemCategoryDTO getItemCategoryDTO() {
        return itemCategoryDTO;
    }

    public void setItemCategoryDTO(ItemCategoryDTO itemCategoryDTO) {
        this.itemCategoryDTO = itemCategoryDTO;
    }

    @Override
    public String toString() {
        return "ReleaseOrderDTO{" +
                "orderNo=" + orderNo +
                ", orderDate=" + orderDate +
                ", orderAmount=" + orderAmount +
                ", cartNo=" + cartNo +
                ", itemNo=" + itemNo +
                ", storeName='" + storeName + '\'' +
                ", itemInfoDTO=" + itemInfoDTO +
                ", itemCategoryDTO=" + itemCategoryDTO +
                '}';
    }
}
