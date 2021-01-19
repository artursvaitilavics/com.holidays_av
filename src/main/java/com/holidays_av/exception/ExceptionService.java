package com.holidays_av.exception;

public class ExceptionService extends RuntimeException {
    private String code;

    public ExceptionService() {
    }

    public ExceptionService(String message, String code) {
        super(message);
        this.code = code;
    }

    public ExceptionService(String message, Throwable cause) {
        super(message, cause);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
