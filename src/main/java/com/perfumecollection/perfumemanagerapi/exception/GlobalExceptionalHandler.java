package com.perfumecollection.perfumemanagerapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionalHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> getMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        Map<String,String> errorMap = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(e ->{
            String errorField = ((FieldError) e).getField();
            String errorMsg = e.getDefaultMessage();
            errorMap.put(errorField, errorMsg);
        });
        return errorMap;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        return "Error: Formato de dato incorrecto o valor de Enum no válido";
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> handleResourceNotFound(ResourceNotFoundException exception){
        Map<String,String> errorResponse = new HashMap<>();
        errorResponse.put("error", exception.getMessage());
        return errorResponse;
    }
}
