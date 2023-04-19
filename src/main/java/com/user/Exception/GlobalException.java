package com.user.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



    @ControllerAdvice
    public class GlobalException {

        @ExceptionHandler(value = NoDataException.class )
        public ResponseEntity<?> Nodata(NoDataException e){
           return new ResponseEntity<>("please provide user details", HttpStatus.BAD_REQUEST);
       }

        @ExceptionHandler(value = NotFoundException.class )
        public ResponseEntity<?> NotFound(NotFoundException e){
            return new ResponseEntity<>("It was not found", HttpStatus.BAD_REQUEST);
        }

    }













