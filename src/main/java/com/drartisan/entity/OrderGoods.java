package com.drartisan.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by summer on 2017/4/25.
 */
@Entity
public class OrderGoods {
    private int orderId;
    private String orderType;
    private int goodsId;
    private int subGoodsId;
    private int quantity;
    private double price;

    @Id
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getSubGoodsId() {
        return subGoodsId;
    }

    public void setSubGoodsId(int subGoodsId) {
        this.subGoodsId = subGoodsId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
