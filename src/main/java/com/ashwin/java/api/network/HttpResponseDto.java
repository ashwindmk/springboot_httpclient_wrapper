package com.ashwin.java.api.network;

public class HttpResponseDto<T> {
    private Integer status;
    private String message;
    private String reason;
    private T data;

    public HttpResponseDto() {
    }

    public HttpResponseDto(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpResponseDto(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HttpResponseDto{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", reason='" + reason + '\'' +
                ", data=" + data +
                '}';
    }
}
