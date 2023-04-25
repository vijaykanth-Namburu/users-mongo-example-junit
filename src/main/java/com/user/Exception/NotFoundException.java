package com.user.Exception;

public class NotFoundException extends Exception {

    String msg;
    String fieldName ;
    int fieldValue;


    public NotFoundException(String msg ,String fieldName ,int fieldValue) {
        //super();
        super(String.format("%s not found with %s : '%s'", msg, fieldName, fieldValue));

        this.msg = msg;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
