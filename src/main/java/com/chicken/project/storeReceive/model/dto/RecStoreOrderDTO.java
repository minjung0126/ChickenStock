package com.chicken.project.storeReceive.model.dto;

import com.chicken.project.item.model.dto.ItemCategoryDTO;
import com.chicken.project.item.model.dto.ItemFileDTO;
import com.chicken.project.item.model.dto.ItemInfoDTO;

import java.sql.Date;

public class RecStoreOrderDTO {

    private int orderNo;
    private java.sql.Date orderDate;
    private String orderCode;
    private String countOrderNo;
    private int rNum;
    private RecOrderHandlerDTO recOrderHandler;
    private RecCartDTO recCart;
    private ItemInfoDTO itemInfo;
    private ItemFileDTO itemFile;
    private ItemCategoryDTO itemCategory;
    private RecRelOrdHandlerDTO recRelOrdHandler;
    private RecReleaseItemDTO recReleaseItem;
    private ReceiveStoreDTO receiveStore;


    public RecStoreOrderDTO() {
    }

    public RecStoreOrderDTO(int orderNo, Date orderDate, String orderCode, String countOrderNo, int rNum, RecOrderHandlerDTO recOrderHandler, RecCartDTO recCart, ItemInfoDTO itemInfo, ItemFileDTO itemFile, ItemCategoryDTO itemCategory, RecRelOrdHandlerDTO recRelOrdHandler, RecReleaseItemDTO recReleaseItem, ReceiveStoreDTO receiveStore) {
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.orderCode = orderCode;
        this.countOrderNo = countOrderNo;
        this.rNum = rNum;
        this.recOrderHandler = recOrderHandler;
        this.recCart = recCart;
        this.itemInfo = itemInfo;
        this.itemFile = itemFile;
        this.itemCategory = itemCategory;
        this.recRelOrdHandler = recRelOrdHandler;
        this.recReleaseItem = recReleaseItem;
        this.receiveStore = receiveStore;
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

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCountOrderNo() {
        return countOrderNo;
    }

    public void setCountOrderNo(String countOrderNo) {
        this.countOrderNo = countOrderNo;
    }

    public int getrNum() {
        return rNum;
    }

    public void setrNum(int rNum) {
        this.rNum = rNum;
    }

    public RecOrderHandlerDTO getRecOrderHandler() {
        return recOrderHandler;
    }

    public void setRecOrderHandler(RecOrderHandlerDTO recOrderHandler) {
        this.recOrderHandler = recOrderHandler;
    }

    public RecCartDTO getRecCart() {
        return recCart;
    }

    public void setRecCart(RecCartDTO recCart) {
        this.recCart = recCart;
    }

    public ItemInfoDTO getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(ItemInfoDTO itemInfo) {
        this.itemInfo = itemInfo;
    }

    public ItemFileDTO getItemFile() {
        return itemFile;
    }

    public void setItemFile(ItemFileDTO itemFile) {
        this.itemFile = itemFile;
    }

    public ItemCategoryDTO getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategoryDTO itemCategory) {
        this.itemCategory = itemCategory;
    }

    public RecRelOrdHandlerDTO getRecRelOrdHandler() {
        return recRelOrdHandler;
    }

    public void setRecRelOrdHandler(RecRelOrdHandlerDTO recRelOrdHandler) {
        this.recRelOrdHandler = recRelOrdHandler;
    }

    public RecReleaseItemDTO getRecReleaseItem() {
        return recReleaseItem;
    }

    public void setRecReleaseItem(RecReleaseItemDTO recReleaseItem) {
        this.recReleaseItem = recReleaseItem;
    }

    public ReceiveStoreDTO getReceiveStore() {
        return receiveStore;
    }

    public void setReceiveStore(ReceiveStoreDTO receiveStore) {
        this.receiveStore = receiveStore;
    }

    @Override
    public String toString() {
        return "RecStoreOrderDTO{" +
                "orderNo=" + orderNo +
                ", orderDate=" + orderDate +
                ", orderCode='" + orderCode + '\'' +
                ", countOrderNo='" + countOrderNo + '\'' +
                ", rNum=" + rNum +
                ", recOrderHandler=" + recOrderHandler +
                ", recCart=" + recCart +
                ", itemInfo=" + itemInfo +
                ", itemFile=" + itemFile +
                ", itemCategory=" + itemCategory +
                ", recRelOrdHandler=" + recRelOrdHandler +
                ", recReleaseItem=" + recReleaseItem +
                ", receiveStore=" + receiveStore +
                '}';
    }
}
