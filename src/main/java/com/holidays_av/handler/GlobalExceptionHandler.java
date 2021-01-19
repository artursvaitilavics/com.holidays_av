package com.holidays_av.handler;

import com.holidays_av.exception.ErrorResponse;
import com.holidays_av.exception.ExceptionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ErrorResponse handleAnyException(
            MethodArgumentNotValidException exception,
            WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode("Wrong input value...");
        List<String> errorsDescending = exception
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(t -> t.getObjectName() + " " + t.getDefaultMessage())
                .collect(Collectors.toList());
        errorResponse.setMessage(StringUtils.join(errorsDescending, ", "));
        errorResponse.setOperation(request.getContextPath());
        return errorResponse;
    }


    @ExceptionHandler(value = {ExceptionService.class})
    public ErrorResponse handleAnyException(ExceptionService exceptionService) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setOperation("Operation failed...");
        errorResponse.setMessage(exceptionService.getMessage());
        errorResponse.setCode(exceptionService.getCode());
        return errorResponse;
    }


}
