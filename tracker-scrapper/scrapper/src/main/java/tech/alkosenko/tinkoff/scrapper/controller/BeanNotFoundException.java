package tech.alkosenko.tinkoff.scrapper.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

record handleResponse(String description, HttpStatus code, String exceptionName,
                      String exceptionMessage, StackTraceElement[] stacktrace) {}

@RestControllerAdvice
class GlobalControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
    public handleResponse handleNoTFound(Exception e, WebRequest request) {
        return new handleResponse(e.getMessage(), HttpStatus.NOT_FOUND,
                e.getClass().getCanonicalName(), e.getMessage(), e.getStackTrace());
    }
}