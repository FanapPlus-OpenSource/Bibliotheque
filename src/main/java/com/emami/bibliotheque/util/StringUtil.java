package com.emami.bibliotheque.util;

import java.util.regex.Pattern;

public class StringUtil {
    static final String REGEX = "[!@#$%^&*)(/\\[\\]\\\\+=.,:;_'-]";

    //Checks if string starts or ends with invalid chars
    public static Boolean checkIfStringBoundariesAreInvalid(String content) {
        return checkStartPattern(content) || checkEndPattern(content);
    }

    private static Boolean checkStartPattern(String content) {
        String regexStart = "^" + REGEX;
        Pattern pattern = Pattern.compile(regexStart, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(content).find();
    }

    private static Boolean checkEndPattern(String content) {
        String regexEnd = REGEX + "$";
        Pattern pattern = Pattern.compile(regexEnd, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(content).find();
    }
}
