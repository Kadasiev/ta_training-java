package com.epam.training.student_david_kadasiev.working_with_strings.validations_epam_email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
        if(email == null)
            return false;

        Pattern pattern = Pattern.compile("\\w+_\\w+[1-9]*@epam.com");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}


