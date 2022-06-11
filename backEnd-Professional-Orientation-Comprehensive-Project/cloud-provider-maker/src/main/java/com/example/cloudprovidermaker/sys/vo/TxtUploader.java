package com.example.cloudprovidermaker.sys.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TxtUploader {
    @JsonProperty(value = "result")
    private Boolean result;

    @JsonProperty(value = "message")
    private String message;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
