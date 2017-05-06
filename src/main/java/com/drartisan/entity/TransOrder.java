package com.drartisan.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.HashMap;
import java.util.List;

/**
 * Created by summer on 2017/4/25.
 */
@Entity
public class TransOrder {
    @Id
    private String orderId;
    private int branchStoreId;
    private int mainStoreId;
    private String addressName;
    private String addressPhone;
    private String addressDetail;
    private double totalPrice;
    private String createTime;
    private String sendTime;
    private String reciveTime;
    private String transCompany;
    private String transOrder;
    private String transContent;
    private String state;
    @Transient
    private List<HashMap<String,Integer>> subGoodsIdQuantitys;
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

    public List<HashMap<String, Integer>> getSubGoodsIdQuantitys() {
        return subGoodsIdQuantitys;
    }

    public void setSubGoodsIdQuantitys(List<HashMap<String, Integer>> subGoodsIdQuantitys) {
        this.subGoodsIdQuantitys = subGoodsIdQuantitys;
    }

    public List<OrderGoods> getOrderGoodses() {
        return orderGoodses;
    }

    public void setOrderGoodses(List<OrderGoods> orderGoodses) {
        this.orderGoodses = orderGoodses;
    }

    public TransOrder() {
    }

    public TransOrder(String orderId, int branchStoreId, int mainStoreId, String addressName, String addressPhone, String addressDetail, double totalPrice, String createTime, String sendTime, String reciveTime, String transCompany, String transOrder, String transContent, String state, List<HashMap<String, Integer>> subGoodsIdQuantitys, List<OrderGoods> orderGoodses) {
        this.orderId = orderId;
        this.branchStoreId = branchStoreId;
        this.mainStoreId = mainStoreId;
        this.addressName = addressName;
        this.addressPhone = addressPhone;
        this.addressDetail = addressDetail;
        this.totalPrice = totalPrice;
        this.createTime = createTime;
        this.sendTime = sendTime;
        this.reciveTime = reciveTime;
        this.transCompany = transCompany;
        this.transOrder = transOrder;
        this.transContent = transContent;
        this.state = state;
        this.subGoodsIdQuantitys = subGoodsIdQuantitys;
        this.orderGoodses = orderGoodses;
    }
}
