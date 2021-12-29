package com.exam.exception.handler;

import com.exam.exceptions.UserFoundException;
import com.exam.exceptions.UserNotFoundException;
import com.exam.helper.RestApiError;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler
{


    @Value("${rest.api.error.msg}")
    private  String errorMsg;

    @ExceptionHandler(value = UserFoundException.class)
    public ResponseEntity<RestApiError> handleUserFoundException(UserFoundException excObj)
    {
        return  new ResponseEntity<>(new RestApiError(errorMsg,excObj.getMsg()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<RestApiError> handleUserNotFoundException(UserNotFoundException excObj)
    {
        return  new ResponseEntity<>(new RestApiError(errorMsg,excObj.getMsg()), HttpStatus.INTERNAL_SERVER_ERROR);
    }



    @ExceptionHandler(com.exam.exceptions.MethodArgumentNotValidException.class)
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        System.out.println("Validation Error Method getting executed!!!!");
        List<String> details = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        return new ResponseEntity<>(new RestApiError(errorMsg,"Validation error",details),HttpStatus.BAD_REQUEST);
    }
}
