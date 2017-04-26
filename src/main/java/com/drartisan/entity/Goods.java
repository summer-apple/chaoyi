package com.drartisan.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by summer on 2017/4/25.
 */
@Entity
public class Goods {

    @Id
    private int goodsId;
    private String goodsNo;
    private int categoryId;
    private String imgUrl;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
