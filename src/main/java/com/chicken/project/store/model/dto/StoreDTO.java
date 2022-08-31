package com.chicken.project.store.model.dto;

public class StoreDTO {

    private String storeName;
    private String storeAccount;
    private String storeRep;
    private String storeAddress;
    private String storePhone;
    private String storeEmail;
    private String storeId;
    private String storePwd;
    private String storeNo;
    private String memberType;

    public StoreDTO() {}

    public StoreDTO(String storeName, String storeAccount, String storeRep,
                    String storeAddress, String storePhone, String storeEmail,
                    String storeId, String storePwd, String storeNo, String memberType) {
        this.storeName = storeName;
        this.storeAccount = storeAccount;
        this.storeRep = storeRep;
        this.storeAddress = storeAddress;
        this.storePhone = storePhone;
        this.storeEmail = storeEmail;
        this.storeId = storeId;
        this.storePwd = storePwd;
        this.storeNo = storeNo;
        this.memberType = memberType;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAccount() {
        return storeAccount;
    }

    public void setStoreAccount(String storeAccount) {
        this.storeAccount = storeAccount;
    }

    public String getStoreRep() {
        return storeRep;
    }

    public void setStoreRep(String storeRep) {
        this.storeRep = storeRep;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreEmail() {
        return storeEmail;
    }

    public void setStoreEmail(String storeEmail) {
        this.storeEmail = storeEmail;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStorePwd() {
        return storePwd;
    }

    public void setStorePwd(String storePwd) {
        this.storePwd = storePwd;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    @Override
    public String toString() {
        return "StoreDTO{" +
                "storeName='" + storeName + '\'' +
                ", storeAccount='" + storeAccount + '\'' +
                ", storeRep='" + storeRep + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", storePhone='" + storePhone + '\'' +
                ", storeEmail='" + storeEmail + '\'' +
                ", storeId='" + storeId + '\'' +
                ", storePwd='" + storePwd + '\'' +
                ", storeNo='" + storeNo + '\'' +
                ", memberType='" + memberType + '\'' +
                '}';
    }
}
