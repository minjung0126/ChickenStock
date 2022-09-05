package com.chicken.project.receive.model.dto;

import com.chicken.project.empList.model.dto.EmployeeDTO;
import com.chicken.project.item.model.dto.ItemCategoryDTO;
import com.chicken.project.item.model.dto.ItemFileDTO;
import com.chicken.project.item.model.dto.ItemInfoDTO;

import java.sql.Date;
import java.util.List;

public class ReceiveOfficeDTO {

    private String recCode;
    private java.sql.Date recDate;
    private String memberId;
    private int sumRecTotalAmount; // 총 입고 수량
    private int countRecCode; // 입고 상품 종류 개수
    private String sumRecTotalMoney; // 총 입고 금액
    private String stringRecDate; // 입고일 ('yyyy-dd-mm')

    private ReceiveOfficeItemDTO receiveOfficeItem;
    private ItemInfoDTO itemInfo;
    private ItemCategoryDTO itemCategory;
    private ItemFileDTO itemFile;
    private EmployeeDTO employee;

    private List<ReceiveOfficeItemDTO> receiveOfficeItemList;

    public ReceiveOfficeDTO() {
    }

    public ReceiveOfficeDTO(String recCode, Date recDate, String memberId, int sumRecTotalAmount, int countRecCode, String sumRecTotalMoney, String stringRecDate, ReceiveOfficeItemDTO receiveOfficeItem, ItemInfoDTO itemInfo, ItemCategoryDTO itemCategory, ItemFileDTO itemFile, EmployeeDTO employee, List<ReceiveOfficeItemDTO> receiveOfficeItemList) {
        this.recCode = recCode;
        this.recDate = recDate;
        this.memberId = memberId;
        this.sumRecTotalAmount = sumRecTotalAmount;
        this.countRecCode = countRecCode;
        this.sumRecTotalMoney = sumRecTotalMoney;
        this.stringRecDate = stringRecDate;
        this.receiveOfficeItem = receiveOfficeItem;
        this.itemInfo = itemInfo;
        this.itemCategory = itemCategory;
        this.itemFile = itemFile;
        this.employee = employee;
        this.receiveOfficeItemList = receiveOfficeItemList;
    }

    public String getRecCode() {
        return recCode;
    }

    public void setRecCode(String recCode) {
        this.recCode = recCode;
    }

    public Date getRecDate() {
        return recDate;
    }

    public void setRecDate(Date recDate) {
        this.recDate = recDate;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getSumRecTotalAmount() {
        return sumRecTotalAmount;
    }

    public void setSumRecTotalAmount(int sumRecTotalAmount) {
        this.sumRecTotalAmount = sumRecTotalAmount;
    }

    public int getCountRecCode() {
        return countRecCode;
    }

    public void setCountRecCode(int countRecCode) {
        this.countRecCode = countRecCode;
    }

    public String getSumRecTotalMoney() {
        return sumRecTotalMoney;
    }

    public void setSumRecTotalMoney(String sumRecTotalMoney) {
        this.sumRecTotalMoney = sumRecTotalMoney;
    }

    public String getStringRecDate() {
        return stringRecDate;
    }

    public void setStringRecDate(String stringRecDate) {
        this.stringRecDate = stringRecDate;
    }

    public ReceiveOfficeItemDTO getReceiveOfficeItem() {
        return receiveOfficeItem;
    }

    public void setReceiveOfficeItem(ReceiveOfficeItemDTO receiveOfficeItem) {
        this.receiveOfficeItem = receiveOfficeItem;
    }

    public ItemInfoDTO getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(ItemInfoDTO itemInfo) {
        this.itemInfo = itemInfo;
    }

    public ItemCategoryDTO getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategoryDTO itemCategory) {
        this.itemCategory = itemCategory;
    }

    public ItemFileDTO getItemFile() {
        return itemFile;
    }

    public void setItemFile(ItemFileDTO itemFile) {
        this.itemFile = itemFile;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public List<ReceiveOfficeItemDTO> getReceiveOfficeItemList() {
        return receiveOfficeItemList;
    }

    public void setReceiveOfficeItemList(List<ReceiveOfficeItemDTO> receiveOfficeItemList) {
        this.receiveOfficeItemList = receiveOfficeItemList;
    }

    @Override
    public String toString() {
        return "ReceiveOfficeDTO{" +
                "recCode='" + recCode + '\'' +
                ", recDate=" + recDate +
                ", memberId='" + memberId + '\'' +
                ", sumRecTotalAmount=" + sumRecTotalAmount +
                ", countRecCode=" + countRecCode +
                ", sumRecTotalMoney='" + sumRecTotalMoney + '\'' +
                ", stringRecDate='" + stringRecDate + '\'' +
                ", receiveOfficeItem=" + receiveOfficeItem +
                ", itemInfo=" + itemInfo +
                ", itemCategory=" + itemCategory +
                ", itemFile=" + itemFile +
                ", employee=" + employee +
                ", receiveOfficeItemList=" + receiveOfficeItemList +
                '}';
    }
}
