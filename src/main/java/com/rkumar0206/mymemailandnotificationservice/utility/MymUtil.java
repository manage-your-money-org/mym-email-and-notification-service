package com.rkumar0206.mymemailandnotificationservice.utility;

import com.rkumar0206.mymemailandnotificationservice.constants.Constants;

public class MymUtil {

    public static boolean isValid(String str) {

        return str != null && !str.trim().isEmpty();
    }

    public static boolean isNotValid(String str) {

        return !isValid(str);
    }

    public static String createLog(String correlationId, String message) {

        return String.format(Constants.LOG_MESSAGE_STRUCTURE, correlationId, message);
    }

}
