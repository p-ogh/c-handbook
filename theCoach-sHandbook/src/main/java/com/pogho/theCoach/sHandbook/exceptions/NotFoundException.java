package com.pogho.theCoach.sHandbook.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(){
        super("Member ID not found.");
    }

    public NotFoundException(String message){
        super(message);
    }
}
