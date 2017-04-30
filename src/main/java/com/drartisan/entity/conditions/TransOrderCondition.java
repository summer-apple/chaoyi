package com.drartisan.entity.conditions;

/**
 * Created by summer on 2017/4/27.
 */
public class TransOrderCondition {
    private String orderId;
    private int branchStoreId;
    private int mainStoreId;
    private double totalPrice;
    private String createTimeMin;
    private String createTimeMax;
    private String state;

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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCreateTimeMin() {
        return createTimeMin;
    }

    public void setCreateTimeMin(String createTimeMin) {
        this.createTimeMin = createTimeMin;
    }

    public String getCreateTimeMax() {
        return createTimeMax;
    }

    public void setCreateTimeMax(String createTimeMax) {
        this.createTimeMax = createTimeMax;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
