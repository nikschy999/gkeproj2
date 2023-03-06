package com.example.demo.ResponseClass;

import java.util.List;


public class CommonResponse<T> {

    private boolean isProcessingSuccess = true;
    private boolean isValidationSuccess = true;
    private int responseCode = 200;
    private T responseObject;
    private List<String> errors;

    public boolean isIsProcessingSuccess() {
        return this.isProcessingSuccess;
    }

    public boolean getIsProcessingSuccess() {
        return this.isProcessingSuccess;
    }

    public void setIsProcessingSuccess(boolean isProcessingSuccess) {
        this.isProcessingSuccess = isProcessingSuccess;
    }

    public boolean isIsValidationSuccess() {
        return this.isValidationSuccess;
    }

    public boolean getIsValidationSuccess() {
        return this.isValidationSuccess;
    }

    public void setIsValidationSuccess(boolean isValidationSuccess) {
        this.isValidationSuccess = isValidationSuccess;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public T getResponseObject() {
        return this.responseObject;
    }

    public void setResponseObject(T response) {
        this.responseObject = response;
    }

    public List<String> getErrors() {
        return this.errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }


}
