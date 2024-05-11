package com.pogho.theCoach.sHandbook.controller;

import com.pogho.theCoach.sHandbook.DTO.ErrorDTO;
import com.pogho.theCoach.sHandbook.exceptions.NoNameException;
import com.pogho.theCoach.sHandbook.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request){

        return new ResponseEntity<>("An error occured: "+ ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({NotFoundException.class, NoNameException.class})
    public ResponseEntity<ErrorDTO> handleNoUserFoundException(Exception ex){

        return new ResponseEntity<>(new ErrorDTO( "Error", ex.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }


}
