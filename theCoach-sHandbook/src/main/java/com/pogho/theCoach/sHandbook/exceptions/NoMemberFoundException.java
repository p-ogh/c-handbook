package com.pogho.theCoach.sHandbook.exceptions;

public class NoMemberFoundException extends RuntimeException{

    public NoMemberFoundException(){
        super("Member ID not found.");
    }

    public NoMemberFoundException(String message){
        super(message);
    }
}
