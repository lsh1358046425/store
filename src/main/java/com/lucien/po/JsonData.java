package com.lucien.po;

/**
 * @author Lucien
 * @version 1.0
 * @description TODO
 * @date 2019/5/11 14:45
 */
public class JsonData {
    private int status;

    private String msg;

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
