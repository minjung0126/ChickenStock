package com.chicken.project.billTax.model.dto;

import java.util.Date;


public class TaxBillDTO {

    private int taxNo;   //세금계산서 번호
    private String itemName; // 품목
    private String itemStandard; //규격
    private int orderAmount; //수량
    private int itemSales;  //매출단가
    private java.util.Date orderDate; //발주날짜
    private java.util.Date taxDate; //세금계산서 발급날짜
    private String storeNo; // 사업자등록번호
    private String storeName; // 가맹점상호
    private String storeAddress; //가맹점 주소

    private String storeRef; // 가맹점주 이름

    public TaxBillDTO() { }

    public TaxBillDTO(int taxNo, String itemName, String itemStandard, int orderAmount, int itemSales, Date orderDate, Date taxDate, String storeNo, String storeName, String storeAddress, String storeRef) {
        this.taxNo = taxNo;
        this.itemName = itemName;
        this.itemStandard = itemStandard;
        this.orderAmount = orderAmount;
        this.itemSales = itemSales;
        this.orderDate = orderDate;
        this.taxDate = taxDate;
        this.storeNo = storeNo;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storeRef = storeRef;
    }

    public int getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(int taxNo) {
        this.taxNo = taxNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemStandard() {
        return itemStandard;
    }

    public void setItemStandard(String itemStandard) {
        this.itemStandard = itemStandard;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public int getItemSales() {
        return itemSales;
    }

    public void setItemSales(int itemSales) {
        this.itemSales = itemSales;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getTaxDate() {
        return taxDate;
    }

    public void setTaxDate(Date taxDate) {
        this.taxDate = taxDate;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStoreRef() {
        return storeRef;
    }

    public void setStoreRef(String storeRef) {
        this.storeRef = storeRef;
    }

    @Override
    public String toString() {
        return "TaxBillDTO{" +
                "taxNo=" + taxNo +
                ", itemName='" + itemName + '\'' +
                ", itemStandard='" + itemStandard + '\'' +
                ", orderAmount=" + orderAmount +
                ", itemSales=" + itemSales +
                ", orderDate=" + orderDate +
                ", taxDate=" + taxDate +
                ", storeNo='" + storeNo + '\'' +
                ", storeName='" + storeName + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", storeRef='" + storeRef + '\'' +
                '}';
    }
}
