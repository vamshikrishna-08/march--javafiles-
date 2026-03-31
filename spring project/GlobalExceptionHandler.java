package com.example.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log  = LoggerFactory.getLogger(GlobalExceptionHandler.class);
   @ExceptionHandler(ResourceNotFoundException.class)
   @ResponseStatus(HttpStatus.NOT_FOUND)
   public String handeResourceNotFound(ResourceNotFoundException ex){
   log.error("Exception occurred : {}" , ex.getMessage());
    return  "Global Exception:" + ex.getMessage();
   }
   @ExceptionHandler(Exception.class)
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
   public String handleGlobalException(Exception ex){
    log.error("unexcepted error: {}", ex.getMessage());
    return "something went wrong : " + ex.getMessage();
   }
}
