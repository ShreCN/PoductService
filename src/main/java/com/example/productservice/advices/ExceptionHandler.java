package com.example.productservice.advices;

import com.example.productservice.dtos.ExceptionDto;
import com.example.productservice.exceptions.ProductLimitReachedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ProductLimitReachedException.class)
    public ResponseEntity<ExceptionDto> customExceptionHandler(){
        System.out.println("Something went Wrong");
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setErrorCode("PRODUCT_LIMIT_REACHED");
        exceptionDto.setMessage("Custom Exception Handling");
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);

    }
}
