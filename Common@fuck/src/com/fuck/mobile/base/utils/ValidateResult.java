package com.fuck.mobile.base.utils;

/**
 * 
 * @category talent-validate服务端验证结果。
 * @author liwenbin
 *
 */
public class ValidateResult {
    private boolean result = false;

    private String msg = null;

    private String msgId = null;

    /**
     * 
     */
    public ValidateResult() {
    }

    public ValidateResult(boolean result, String msg) {
        this.result = result;
        this.msg = msg;
    }

    public ValidateResult(boolean result, String msg, String msgId) {
        this.result = result;
        this.msg = msg;
        this.msgId = msgId;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgId() {
        return msgId;
    }

}
