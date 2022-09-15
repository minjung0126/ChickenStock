package com.chicken.project.storeItem.model.dto;

import com.chicken.project.item.model.dto.ItemFileDTO;

public class StoreItemListDTO {

    private int itemNo;
    private String itemName;
    private String itemStandard;
    private int itemPurchase;
    private int itemSales;
    private String itemSoldoutYn;
    private String itemMake;
    private int categoryNo;
    private int itemAmount;
    private String soldout;
    private String categoryName;
    private int rNum;
    private String itemDeleteYn;
    private ItemFileDTO itemFile;

    public StoreItemListDTO(int itemNo, String itemName, String itemStandard, int itemPurchase, int itemSales, String itemSoldoutYn, String itemMake, int categoryNo, int itemAmount, String soldout, String categoryName, int rNum, String itemDeleteYn, ItemFileDTO itemFile) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.itemStandard = itemStandard;
        this.itemPurchase = itemPurchase;
        this.itemSales = itemSales;
        this.itemSoldoutYn = itemSoldoutYn;
        this.itemMake = itemMake;
        this.categoryNo = categoryNo;
        this.itemAmount = itemAmount;
        this.soldout = soldout;
        this.categoryName = categoryName;
        this.rNum = rNum;
        this.itemDeleteYn = itemDeleteYn;
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

    public String getItemStandard() {
        return itemStandard;
    }

    public void setItemStandard(String itemStandard) {
        this.itemStandard = itemStandard;
    }

    public int getItemPurchase() {
        return itemPurchase;
    }

    public void setItemPurchase(int itemPurchase) {
        this.itemPurchase = itemPurchase;
    }

    public int getItemSales() {
        return itemSales;
    }

    public void setItemSales(int itemSales) {
        this.itemSales = itemSales;
    }

    public String getItemSoldoutYn() {
        return itemSoldoutYn;
    }

    public void setItemSoldoutYn(String itemSoldoutYn) {
        this.itemSoldoutYn = itemSoldoutYn;
    }

    public String getItemMake() {
        return itemMake;
    }

    public void setItemMake(String itemMake) {
        this.itemMake = itemMake;
    }

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }

    public String getSoldout() {
        return soldout;
    }

    public void setSoldout(String soldout) {
        this.soldout = soldout;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getrNum() {
        return rNum;
    }

    public void setrNum(int rNum) {
        this.rNum = rNum;
    }

    public String getItemDeleteYn() {
        return itemDeleteYn;
    }

    public void setItemDeleteYn(String itemDeleteYn) {
        this.itemDeleteYn = itemDeleteYn;
    }

    public ItemFileDTO getItemFile() {
        return itemFile;
    }

    public void setItemFile(ItemFileDTO itemFile) {
        this.itemFile = itemFile;
    }

    @Override
    public String toString() {
        return "StoreItemListDTO{" +
                "itemNo=" + itemNo +
                ", itemName='" + itemName + '\'' +
                ", itemStandard='" + itemStandard + '\'' +
                ", itemPurchase=" + itemPurchase +
                ", itemSales=" + itemSales +
                ", itemSoldoutYn='" + itemSoldoutYn + '\'' +
                ", itemMake='" + itemMake + '\'' +
                ", categoryNo=" + categoryNo +
                ", itemAmount=" + itemAmount +
                ", soldout='" + soldout + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", rNum=" + rNum +
                ", itemDeleteYn='" + itemDeleteYn + '\'' +
                ", itemFile=" + itemFile +
                '}';
    }
}
