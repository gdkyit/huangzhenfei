package com.database.demo.utils;

/**
 * Created by lenovo on 2017  七月  21  0021.
 */
public class ResponseMessage {
    private String code;
    private String error;
    private Object result;

    public ResponseMessage(String code, String error, Object result) {
        this.code = code;
        this.error = error;
        this.result = result;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
