package com.lucien.util;

import org.springframework.util.DigestUtils;

/**
 * @author Lucien
 * @version 1.0
 * @description TODO
 * @date 2019/5/11 12:46
 */
public class MD5Util {
    private static final String slat = "*#$lucien$#*";

    public static String getMD5(String password) {
        String fix = password +"/"+slat;
        String md5 = DigestUtils.md5DigestAsHex(fix.getBytes());
        return md5;
    }
}
