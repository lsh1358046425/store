package com.lucien.model.entity;

/**
 * @author Lucien
 * @version 1.0
 * @date 2019/5/8 23:25
 */
public class LayUITableData {
    private Integer code;

    private String msg;

    private Long count;

    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
