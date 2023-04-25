package com.user.Exception;

public class NoDataException extends Exception {
        String msg;
        String fieldName;
        int fieldValue;

        public NoDataException(String msg, String fieldName, int fieldValue) {
            super(String.format("%s not found with %s : '%s'", msg, fieldName, fieldValue));

            this.msg = msg;
            this.fieldName = fieldName;
            this.fieldValue = fieldValue;
        }
}
