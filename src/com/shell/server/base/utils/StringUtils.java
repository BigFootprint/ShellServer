package com.shell.server.base.utils;

/**
 * Created by liquanmin on 15/11/24.
 */
public class StringUtils {
    public static boolean isEmpty(String str){
        if(str == null || str.equals(""))
            return true;

        return false;
    }
}
