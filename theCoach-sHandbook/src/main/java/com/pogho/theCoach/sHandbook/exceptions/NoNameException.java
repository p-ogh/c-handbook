package com.pogho.theCoach.sHandbook.exceptions;

public class NoNameException extends RuntimeException{

    public NoNameException(){
        super("Name cannot be empty or null.");
    }

    public NoNameException(String message){
        super(message);
    }
}
