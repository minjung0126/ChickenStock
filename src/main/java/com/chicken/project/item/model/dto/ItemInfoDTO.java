package com.chicken.project.item.model.dto;

public class ItemInfoDTO {

    private int itemNo;
    private String itemName;
    private String itemStandard;
    private int itemPurchase;
    private int itemSales;
    private String itemSoldoutYn;
    private String itemMake;
    private int categoryNo;
    private int itemAmount;

    public ItemInfoDTO() {
    }

    public ItemInfoDTO(int itemNo, String itemName, String itemStandard, int itemPurchase, int itemSales, String itemSoldoutYn, String itemMake, int categoryNo, int itemAmount) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.itemStandard = itemStandard;
        this.itemPurchase = itemPurchase;
        this.itemSales = itemSales;
        this.itemSoldoutYn = itemSoldoutYn;
        this.itemMake = itemMake;
        this.categoryNo = categoryNo;
        this.itemAmount = itemAmount;
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

    @Override
    public String toString() {
        return "ItemInfoDTO{" +
                "itemNo=" + itemNo +
                ", itemName='" + itemName + '\'' +
                ", itemStandard='" + itemStandard + '\'' +
                ", itemPurchase=" + itemPurchase +
                ", itemSales=" + itemSales +
                ", itemSoldoutYn='" + itemSoldoutYn + '\'' +
                ", itemMake='" + itemMake + '\'' +
                ", categoryNo=" + categoryNo +
                ", itemAmount=" + itemAmount +
                '}';
    }
}