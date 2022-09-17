package com.chicken.project.order.model.dto;

import java.util.Date;

public class OrderHistoryDTO {

    private int itemNo;
    private String itemName;
    private String categoryName;
    private int categoryNo;
    private String itemStandard;
    private String itemMake;
    private int itemSales;
    private int cartAmount;
    private String itemSoldoutYn;
    private String cartYn;
    private String storeName;
    private int cartNo;
    private int orderNo;
    private Date orderDate;
    private OrderItemFileDTO itemFile;

    public OrderHistoryDTO() {
    }

    public OrderHistoryDTO(int itemNo, String itemName, String categoryName, int categoryNo, String itemStandard, String itemMake, int itemSales, int cartAmount, String itemSoldoutYn, String cartYn, String storeName, int cartNo, int orderNo, Date orderDate, OrderItemFileDTO itemFile) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.categoryName = categoryName;
        this.categoryNo = categoryNo;
        this.itemStandard = itemStandard;
        this.itemMake = itemMake;
        this.itemSales = itemSales;
        this.cartAmount = cartAmount;
        this.itemSoldoutYn = itemSoldoutYn;
        this.cartYn = cartYn;
        this.storeName = storeName;
        this.cartNo = cartNo;
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.itemFile = itemFile;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getItemStandard() {
        return itemStandard;
    }

    public void setItemStandard(String itemStandard) {
        this.itemStandard = itemStandard;
    }

    public String getItemMake() {
        return itemMake;
    }

    public void setItemMake(String itemMake) {
        this.itemMake = itemMake;
    }

    public int getItemSales() {
        return itemSales;
    }

    public void setItemSales(int itemSales) {
        this.itemSales = itemSales;
    }

    public int getCartAmount() {
        return cartAmount;
    }

    public void setCartAmount(int cartAmount) {
        this.cartAmount = cartAmount;
    }

    public String getItemSoldoutYn() {
        return itemSoldoutYn;
    }

    public void setItemSoldoutYn(String itemSoldoutYn) {
        this.itemSoldoutYn = itemSoldoutYn;
    }

    public String getCartYn() {
        return cartYn;
    }

    public void setCartYn(String cartYn) {
        this.cartYn = cartYn;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getCartNo() {
        return cartNo;
    }

    public void setCartNo(int cartNo) {
        this.cartNo = cartNo;
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

    public OrderItemFileDTO getItemFile() {
        return itemFile;
    }

    public void setItemFile(OrderItemFileDTO itemFile) {
        this.itemFile = itemFile;
    }

    @Override
    public String toString() {
        return "OrderHistoryDTO{" +
                "itemNo=" + itemNo +
                ", itemName='" + itemName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", categoryNo=" + categoryNo +
                ", itemStandard='" + itemStandard + '\'' +
                ", itemMake='" + itemMake + '\'' +
                ", itemSales=" + itemSales +
                ", cartAmount=" + cartAmount +
                ", itemSoldoutYn='" + itemSoldoutYn + '\'' +
                ", cartYn='" + cartYn + '\'' +
                ", storeName='" + storeName + '\'' +
                ", cartNo=" + cartNo +
                ", orderNo=" + orderNo +
                ", orderDate=" + orderDate +
                ", itemFile=" + itemFile +
                '}';
    }
}