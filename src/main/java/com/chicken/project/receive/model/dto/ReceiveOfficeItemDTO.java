package com.chicken.project.receive.model.dto;

public class ReceiveOfficeItemDTO {

    private int recItemNo;
    private int itemNo;
    private String recCode;
    private int recAmount;

    public ReceiveOfficeItemDTO() {
    }

    public ReceiveOfficeItemDTO(int recItemNo, int itemNo, String recCode, int recAmount) {
        this.recItemNo = recItemNo;
        this.itemNo = itemNo;
        this.recCode = recCode;
        this.recAmount = recAmount;
    }

    public int getRecItemNo() {
        return recItemNo;
    }

    public void setRecItemNo(int recItemNo) {
        this.recItemNo = recItemNo;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public String getRecCode() {
        return recCode;
    }

    public void setRecCode(String recCode) {
        this.recCode = recCode;
    }

    public int getRecAmount() {
        return recAmount;
    }

    public void setRecAmount(int recAmount) {
        this.recAmount = recAmount;
    }

    @Override
    public String toString() {
        return "ReceiveOfficeItem{" +
                "recItemNo=" + recItemNo +
                ", itemNo=" + itemNo +
                ", recCode='" + recCode + '\'' +
                ", recAmount=" + recAmount +
                '}';
    }
}
