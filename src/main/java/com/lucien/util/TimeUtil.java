package com.lucien.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Lucien
 * @version 1.0
 * @description TODO
 * @date 2019/5/24 19:09
 */
public class TimeUtil {
    public static String getCurrentTime() {
        String returnStr = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        returnStr = dateFormat.format(date);
        return returnStr;
    }

    public static String getCurrentTimeByDate(Date date){
        String returnStr = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        returnStr = dateFormat.format(date);
        return returnStr;
    }
}
