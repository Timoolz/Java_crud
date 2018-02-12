package com.sdua.api.bean;

/**
 * Created by sq_09 on 1/30/2018.
 */
public class MyResponse {

    private  String msg;
    private  String status;
    private  Object data;


    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public String getStatus() {
        return status;
    }
}
