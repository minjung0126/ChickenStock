package com.chicken.project.reItem.model.dto;

public class StoreItemDTO {

    private int itemNo; // 품목번호
    private String itemName; // 품목이름
    private int categoryName;  // 카테고리이름
    private String itemStandard; // 품목규격
    private String itemMake; // 제조사
    private String itemSales; // 매출단가
    private String originName; //원본파일명
    private int storeAmount; // 재고수량

    public StoreItemDTO() {
    }

    public StoreItemDTO(int itemNo, String itemName, int categoryName, String itemStandard, String itemMake, String itemSales, String originName, int storeAmount) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.categoryName = categoryName;
        this.itemStandard = itemStandard;
        this.itemMake = itemMake;
        this.itemSales = itemSales;
        this.originName = originName;
        this.storeAmount = storeAmount;
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

    public int getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(int categoryName) {
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

    public String getItemSales() {
        return itemSales;
    }

    public void setItemSales(String itemSales) {
        this.itemSales = itemSales;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public int getStoreAmount() {
        return storeAmount;
    }

    public void setStoreAmount(int storeAmount) {
        this.storeAmount = storeAmount;
    }

    @Override
    public String toString() {
        return "StoreItemDTO{" +
                "itemNo=" + itemNo +
                ", itemName='" + itemName + '\'' +
                ", categoryName=" + categoryName +
                ", itemStandard='" + itemStandard + '\'' +
                ", itemMake='" + itemMake + '\'' +
                ", itemSales='" + itemSales + '\'' +
                ", originName='" + originName + '\'' +
                ", storeAmount=" + storeAmount +
                '}';
    }
}
