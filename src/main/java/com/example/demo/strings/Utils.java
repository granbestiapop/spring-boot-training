package com.example.demo.strings;

import org.springframework.lang.Nullable;

public class Utils {

    public static boolean isNullOrEmpty(@Nullable String str){
        return str == null || str.isEmpty();
    }
}
