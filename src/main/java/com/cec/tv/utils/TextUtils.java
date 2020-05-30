package com.cec.tv.utils;

public class TextUtils {
    public static boolean isEmpty(String dateStr) {
        if (dateStr == null || "".equals(dateStr)){
            return true;
        }
        return false;
    }
}
