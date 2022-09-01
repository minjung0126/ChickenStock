package com.chicken.project.order.model.dto;

import java.util.Date;

public class OrderDTO {

    /* ITEM_INFO, ITEM_FILE, ITEM_CATEGORY, STO_ITEM_INFO, INTEREST join */
    private int itemNo; //상품번호
    private ItemFileDTO originName; //썸네일
    private String itemName; //상품명
    private String categoryName; //카테고리명
    private String itemStandard; //규격
    private String itemMake; //생산자
    private int itemSales; //가격
    private int storeAmount; //재고
    private int orderAmount; //주문량
    private String itemSoldoutYn; //품절여부
    private String interYn; //관심여부
    private Date orderDate; //주문일

    public OrderDTO() {
    }

    public OrderDTO(int itemNo, ItemFileDTO originName, String itemName, String categoryName, String itemStandard, String itemMake, int itemSales, int storeAmount, int orderAmount, String itemSoldoutYn, String interYn, Date orderDate) {
        this.itemNo = itemNo;
        this.originName = originName;
        this.itemName = itemName;
        this.categoryName = categoryName;
        this.itemStandard = itemStandard;
        this.itemMake = itemMake;
        this.itemSales = itemSales;
        this.storeAmount = storeAmount;
        this.orderAmount = orderAmount;
        this.itemSoldoutYn = itemSoldoutYn;
        this.interYn = interYn;
        this.orderDate = orderDate;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public ItemFileDTO getOriginName() {
        return originName;
    }

    public void setOriginName(ItemFileDTO originName) {
        this.originName = originName;
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

    public int getStoreAmount() {
        return storeAmount;
    }

    public void setStoreAmount(int storeAmount) {
        this.storeAmount = storeAmount;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getItemSoldoutYn() {
        return itemSoldoutYn;
    }

    public void setItemSoldoutYn(String itemSoldoutYn) {
        this.itemSoldoutYn = itemSoldoutYn;
    }

    public String getInterYn() {
        return interYn;
    }

    public void setInterYn(String interYn) {
        this.interYn = interYn;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "itemNo=" + itemNo +
                ", originName=" + originName +
                ", itemName='" + itemName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", itemStandard='" + itemStandard + '\'' +
                ", itemMake='" + itemMake + '\'' +
                ", itemSales=" + itemSales +
                ", storeAmount=" + storeAmount +
                ", orderAmount=" + orderAmount +
                ", itemSoldoutYn='" + itemSoldoutYn + '\'' +
                ", interYn='" + interYn + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }
}
