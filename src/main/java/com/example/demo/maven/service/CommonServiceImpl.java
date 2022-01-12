package com.example.demo.maven.service;

import com.example.demo.maven.ErrorInfo;

abstract public class CommonServiceImpl implements CommonService{
    protected ErrorInfo lastError;
    protected Integer serviceCode = 0;

    @Override
    public ErrorInfo getLastError() {
        return lastError;
    }

    protected void defineError(String errorMessage, Integer errorCode) {
        lastError = new ErrorInfo(errorMessage,serviceCode + errorCode);
    }
}
