package com.drartisan.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by summer on 2017/4/25.
 */
@Entity
public class StockGoods {
    @Id
    private int storeId;
    private String orderType;
    private int goodsId;
    private int subGoodsId;
    private double price;
    private int quantity;


    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
