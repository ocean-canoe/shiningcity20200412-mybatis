package com.shiningcity.common.pojo;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = -8476757449407465334L;
    private Boolean success;
    private String message;
    private T data;// get、set方法类型一定为T
    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public BaseResponse(Boolean success, String message, T data) {
        super();
        this.success = success;
        this.message = message;
        this.data = data;
    }
    public BaseResponse(Boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }
    public BaseResponse(Boolean success) {
        super();
        this.success = success;
    }
    public BaseResponse() {
        super();
    }
}
