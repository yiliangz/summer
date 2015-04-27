package com.summer.common.domain;

/**
 * Created by Allen on 2015/4/27.
 */
public class ResponseMessage {

    private boolean status;
    private String msg;

    public ResponseMessage(boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
