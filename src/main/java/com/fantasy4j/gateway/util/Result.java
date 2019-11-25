package com.fantasy4j.gateway.util;

import java.io.Serializable;

/**
 * Created by lihui23 on 2019/11/25
 */
public class Result<T> implements Serializable {

    private boolean result;
    private String message;
    private T data;
    private String code;

    public Result() {
    }

    public Result(boolean result, T data) {
        this.result = result;
        this.data = data;
    }

    public Result(boolean result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public Result(boolean result, String message, T data, String code) {
        this.result = result;
        this.message = message;
        this.data = data;
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isResult() {
        return this.result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
