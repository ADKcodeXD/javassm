package com.adk.ssm.utils;

import java.util.UUID;

public class UUIDutils {
    public static String getUUID(){
        String string=UUID.randomUUID().toString().replace("-","");
        return string;
    }

}
