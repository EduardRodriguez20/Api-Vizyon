package com.edanrh.ApiVizyon.common;

import java.util.regex.Pattern;

public class ValidateEmail {
    private static final String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern pattern = Pattern.compile(emailRegex);

    public static boolean validateEmail(String email){
        return pattern.matcher(email).matches();
    }
}
