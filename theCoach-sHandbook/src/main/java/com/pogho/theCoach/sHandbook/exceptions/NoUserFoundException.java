package com.pogho.theCoach.sHandbook.exceptions;

public class NoUserFoundException extends RuntimeException{

    public NoUserFoundException(){
        super("No Coach found with ID.");
    }

    public NoUserFoundException(String message){
        super(message);
    }
}
