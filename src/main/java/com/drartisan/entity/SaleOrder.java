package com.drartisan.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

/**
 * Created by summer on 2017/4/25.
 */
@Entity
public class SaleOrder {

    @Id
    private String orderId;
    private int branchStoreId;
    private int mainStoreId;
    private String addressName;
    private String addressPhone;
    private String addressDetail;
    private double discount;
    private double totalPrice;
    private String createTime;
    private String sendTime;
    private String reciveTime;
    private String transCompany;
    private String transOrder;
    private String transContent;
    private String state;
    @Transient
    private List<OrderGoods> orderGoodses;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getBranchStoreId() {
        return branchStoreId;
    }

    public void setBranchStoreId(int branchStoreId) {
        this.branchStoreId = branchStoreId;
    }

    public int getMainStoreId() {
        return mainStoreId;
    }

    public void setMainStoreId(int mainStoreId) {
        this.mainStoreId = mainStoreId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getReciveTime() {
        return reciveTime;
    }

    public void setReciveTime(String reciveTime) {
        this.reciveTime = reciveTime;
    }

    public String getTransCompany() {
        return transCompany;
    }

    public void setTransCompany(String transCompany) {
        this.transCompany = transCompany;
    }

    public String getTransOrder() {
        return transOrder;
    }

    public void setTransOrder(String transOrder) {
        this.transOrder = transOrder;
    }

    public String getTransContent() {
        return transContent;
    }

    public void setTransContent(String transContent) {
        this.transContent = transContent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<OrderGoods> getOrderGoodses() {
        return orderGoodses;
    }

    public void setOrderGoodses(List<OrderGoods> orderGoodses) {
        this.orderGoodses = orderGoodses;
    }
}
