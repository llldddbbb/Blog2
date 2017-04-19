package com.ldb.utils;

/**
 * Created by ldb on 2017/4/19.
 */
public class StringUtil {
    public static Boolean isEmpty(String str){
        if(str==null||"".equals(str)){
            return true;
        }else{
            return false;
        }
    }
    public static Boolean isNotEmpty(String str){
        if(str!=null&&!"".equals(str)){
            return true;
        }else{
            return false;
        }
    }
}
