package com.pogho.theCoach.sHandbook.validations;

import com.pogho.theCoach.sHandbook.entities.MemberEntity;
import com.pogho.theCoach.sHandbook.exceptions.NoNameException;

public class MemberValidation {

    public static void validate(MemberEntity member){
        if(member.getFirstName() == null || member.getFirstName().isEmpty()){
            throw new NoNameException("First Name cannot be empty or null.");
        }
    }

    public static void validate(String firstName){
        if(firstName == null || firstName.isEmpty()){
            throw new NoNameException("First Name cannot be empty or null.");
        }
    }
}
