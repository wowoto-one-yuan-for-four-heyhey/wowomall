package com.xmu.wowoto.wowomall.util;


import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/15 18:15
 */
public class RunTimeUtil {
        private static AtomicInteger index = new AtomicInteger();

        public static int getPid() {
            String info = getRunTimeInfo();
            int pid = (new Random()).nextInt();
            int index = info.indexOf("@");
            if (index > 0) {
                pid = Integer.parseInt(info.substring(0, index));
            }
            return pid;
        }

        public static String getRunTimeInfo() {
            RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
            String info = runtime.getName();
            return info;
        }

        public static String getRocketMqUniqeInstanceName() {
            return "pid" + getPid() + "_index" + index.incrementAndGet();
        }

}
