package com.xmu.wowoto.wowomall.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/15 20:44
 */
public class Common {
    private static DateTimeFormatter longFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
    public static LocalDateTime DEFAULT_TIME = LocalDateTime.of(2019,11,11,11,11,11,11);

    /**
     * 生成唯一随机数
     * @param length 增加的几位随机数
     * @return
     */
    public static String getRandomNum(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer(longFormatter.format(LocalDateTime.now()));
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
