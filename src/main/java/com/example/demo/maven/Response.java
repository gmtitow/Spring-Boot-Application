package com.example.demo.maven;

abstract public class Response {
    ResponseStatus status;
    private ErrorInfo errorInfo;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }

    public String getErrorMessage() {
        if (errorInfo == null)
            return null;
        return errorInfo.getErrorMessage();
    }

    public void setErrorMessage(String errorMessage) {
        if (errorInfo == null) {
            errorInfo = new ErrorInfo();
        }
        errorInfo.setErrorMessage(errorMessage);
    }

    public Integer getErrorCode() {
        if (errorInfo == null)
            return null;
        return errorInfo.getErrorCode();
    }

    public void setErrorCode(Integer errorCode) {
        if (errorInfo == null) {
            errorInfo = new ErrorInfo();
        }
        errorInfo.setErrorCode(errorCode);
    }
}
