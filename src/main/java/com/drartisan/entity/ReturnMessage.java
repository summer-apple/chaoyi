package com.drartisan.entity;

import java.util.Objects;

/**
 * Created by summer on 2017/4/30.
 */
public class ReturnMessage {
    private int retCode;
    private String retMsg;
    private Object retContent;


    public int getRetCode() {
        return retCode;
    }

    public ReturnMessage setRetCode(int retCode) {
        this.retCode = retCode;
        return this;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public ReturnMessage setRetMsg(String retMsg) {
        this.retMsg = retMsg;
        return this;
    }

    public Object getRetContent() {
        return retContent;
    }

    public ReturnMessage setRetContent(Object retContent) {
        this.retContent = retContent;
        return this;
    }

    public ReturnMessage(){}

    public ReturnMessage(int retCode, String retMsg, Object retContent) {
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.retContent = retContent;
    }

    public static ReturnMessage failureMsg(){
        return new ReturnMessage(1,"",null);
    }

    public static ReturnMessage successMsg(){
        return new ReturnMessage(1,"",null);
    }
}
