package com.user.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;


@ControllerAdvice
    public class GlobalException {

        @ExceptionHandler(value = NoDataException.class )
        public ResponseEntity<?> Nodata(NoDataException e,WebRequest webRequest){
            ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(),
                    webRequest.getDescription(false));
            return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
       }

        @ExceptionHandler(value = NotFoundException.class )
        public ResponseEntity<?> NotFound(NotFoundException e, WebRequest webRequest){
              ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(),
                        webRequest.getDescription(false));
                return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
        }

    @ExceptionHandler(value = NoitemException.class )
    public ResponseEntity<?> NoitemFound(NotFoundException e, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = Exception.class )
    public ResponseEntity<?> handleGlobalException(NotFoundException e, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    }













