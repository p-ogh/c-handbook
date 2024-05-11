package com.pogho.theCoach.sHandbook.validations;

import com.pogho.theCoach.sHandbook.models.MemberModel;
import com.pogho.theCoach.sHandbook.exceptions.NoNameException;

public class MemberValidation {

    public static void validate(MemberModel member){
        validate(member.getFirstName());
    }

    public static void validate(String firstName){
        if(firstName == null || firstName.isEmpty()){
            throw new NoNameException("First Name cannot be empty or null.");
        }
    }
}
