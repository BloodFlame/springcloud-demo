package com.ydm.provider.exception;

public class NotFoundDepartmentException extends RuntimeException {
    Integer code;

    public NotFoundDepartmentException() {
        super("没有找到符合条件的结果");
        this.code = 10004;
    }
}
