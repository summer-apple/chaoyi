package com.drartisan.entity;

/**
 * Created by summer on 2017/5/1.
 */
public enum TransOrderStateEnum {
    UNCHECKED("1"), // 待审核
    UNSHIP("2"), // 待发货
    SHIPED("3"), // 已发货
    FINISHED("4"), // 已完成
    REFUSED("5"), // 审核不通过
    CANCELD("6"); // 已取消


    private String state;
    TransOrderStateEnum(String state){
        this.state = state;
    }

}
