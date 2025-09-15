package com.example.springjourney.project.rest;

import com.example.springjourney.project.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(annotations= RestController.class)
@Slf4j
@Order(1)
public class GlobalExceptionRestController extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Response> handleMethodArgumentsNotValid(MethodArgumentNotValidException ex,
                                                                     HttpHeaders httpHeaders, HttpStatus httpStatus,
                                                                     WebRequest request) {
        Response response = new Response(httpStatus.toString(), ex.getMessage().toString());
        return new ResponseEntity(response,httpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Response> exceptionHandler(Exception exception){
        Response response = new Response("500",
                exception.getMessage());
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
