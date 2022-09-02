package com.chicken.project.billTax.model.dto;

public class TsBillDTO {

    private int tsNo; // 거래명세서 번호
    private String tsTaxDate;  //거래명세서 발급날짜
    private String itemName; // 품목
    private String itemStandard; //규격
    private int itemSales;  //매출단가
    private String storeNo; // 사업자등록번호
    private String storeName; // 가맹점상호
    private String storeAddress; //가맹점 주소
    private String storeRep; // 가맹점주 이름
    private int recAmount; //입고 수량
    private String recDate; //입고날짜

    public TsBillDTO() {}


    public TsBillDTO(int tsNo, String tsTaxDate, String itemName, String itemStandard, int itemSales, String storeNo, String storeName, String storeAddress, String storeRep, int recAmount, String recDate) {
        this.tsNo = tsNo;
        this.tsTaxDate = tsTaxDate;
        this.itemName = itemName;
        this.itemStandard = itemStandard;
        this.itemSales = itemSales;
        this.storeNo = storeNo;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storeRep = storeRep;
        this.recAmount = recAmount;
        this.recDate = recDate;
    }


    public int getTsNo() {
        return tsNo;
    }

    public void setTsNo(int tsNo) {
        this.tsNo = tsNo;
    }

    public String getTsTaxDate() {
        return tsTaxDate;
    }

    public void setTsTaxDate(String tsTaxDate) {
        this.tsTaxDate = tsTaxDate;
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

    public int getItemSales() {
        return itemSales;
    }

    public void setItemSales(int itemSales) {
        this.itemSales = itemSales;
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

    public String getStoreRep() {
        return storeRep;
    }

    public void setStoreRep(String storeRep) {
        this.storeRep = storeRep;
    }

    public int getRecAmount() {
        return recAmount;
    }

    public void setRecAmount(int recAmount) {
        this.recAmount = recAmount;
    }

    public String getRecDate() {
        return recDate;
    }

    public void setRecDate(String recDate) {
        this.recDate = recDate;
    }

    @Override
    public String toString() {
        return "TsBillDTO{" +
                "tsNo=" + tsNo +
                ", tsTaxDate='" + tsTaxDate + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemStandard='" + itemStandard + '\'' +
                ", itemSales=" + itemSales +
                ", storeNo='" + storeNo + '\'' +
                ", storeName='" + storeName + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", storeRep='" + storeRep + '\'' +
                ", recAmount=" + recAmount +
                ", recDate='" + recDate + '\'' +
                '}';
    }
}
