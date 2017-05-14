package com.drartisan.util;

import com.mysql.jdbc.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by summer on 2017/5/14.
 */
public class CommonUtil {

    public static String getCurrentDatetimeStr(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmss");
        String datestr = sdf.format(new Date());
        return datestr;

    }

    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(CommonUtil.getCurrentDatetimeStr());
        System.out.println(CommonUtil.getRandomString(10));
    }
}

