package com.ldb.controller.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ldb on 2017/4/18.
 */
public class DateUtil {

    public static String getCurrentDateStr(){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
