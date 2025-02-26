package com.example.scy_test_backend.handler;

import com.example.scy_test_backend.common.BaseResponse;
import com.example.scy_test_backend.common.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public BaseResponse<String> handleCustomException(CustomException e) {
        return BaseResponse.error(4000, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse<String> handleGeneralException(Exception e) {
        return BaseResponse.error(5000, e.getMessage());
    }
}
