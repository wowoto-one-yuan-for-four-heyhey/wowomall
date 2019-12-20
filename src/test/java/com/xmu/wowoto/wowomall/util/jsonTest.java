package com.xmu.wowoto.wowomall.util;

import com.xmu.wowoto.wowomall.WowomallApplication;
import com.xmu.wowoto.wowomall.domain.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/19 20:08
 */

@SpringBootTest(classes = WowomallApplication.class)
public class jsonTest {

    @Test
    void Test(){
        String json = "{\n" +
                "    \"errno\": 200,\n" +
                "    \"data\": {\n" +
                "        \"id\": null,\n" +
                "        \"userId\": 10086,\n" +
                "        \"orderSn\": \"P201912191958308261\",\n" +
                "        \"statusCode\": 0,\n" +
                "        \"consignee\": null,\n" +
                "        \"mobile\": null,\n" +
                "        \"message\": null,\n" +
                "        \"goodsPrice\": 1700,\n" +
                "        \"couponPrice\": null,\n" +
                "        \"rebatePrice\": null,\n" +
                "        \"freightPrice\": null,\n" +
                "        \"integralPrice\": null,\n" +
                "        \"shipSn\": null,\n" +
                "        \"shipChannel\": null,\n" +
                "        \"shipTime\": null,\n" +
                "        \"confirmTime\": null,\n" +
                "        \"endTime\": null,\n" +
                "        \"payTime\": null,\n" +
                "        \"parentId\": null,\n" +
                "        \"address\": \"  \",\n" +
                "        \"gmtCreate\": null,\n" +
                "        \"gmtModified\": null,\n" +
                "        \"beDeleted\": null,\n" +
                "        \"addressObj\": {\n" +
                "            \"id\": null,\n" +
                "            \"userId\": null,\n" +
                "            \"cityId\": 147,\n" +
                "            \"provinceId\": null,\n" +
                "            \"countyId\": null,\n" +
                "            \"addressDetail\": null,\n" +
                "            \"mobile\": null,\n" +
                "            \"postalCode\": null,\n" +
                "            \"consignee\": null,\n" +
                "            \"beDefault\": false,\n" +
                "            \"gmtCreate\": null,\n" +
                "            \"gmtModified\": null,\n" +
                "            \"beDeleted\": null,\n" +
                "            \"province\": null,\n" +
                "            \"city\": null,\n" +
                "            \"county\": null\n" +
                "        },\n" +
                "        \"user\": {\n" +
                "            \"id\": 10086,\n" +
                "            \"name\": \"24475120868\",\n" +
                "            \"nickname\": null,\n" +
                "            \"password\": \"123456\",\n" +
                "            \"gender\": 0,\n" +
                "            \"birthday\": null,\n" +
                "            \"mobile\": \"13959288888\",\n" +
                "            \"rebate\": 0,\n" +
                "            \"avatar\": null,\n" +
                "            \"lastLoginTime\": \"2019-12-18T00:14:13\",\n" +
                "            \"lastLoginIp\": \"183.246.224.16\",\n" +
                "            \"userLevel\": 0,\n" +
                "            \"wxOpenId\": null,\n" +
                "            \"sessionKey\": null,\n" +
                "            \"roleId\": 4,\n" +
                "            \"gmtCreate\": \"2019-12-18T00:14:13\",\n" +
                "            \"gmtModified\": null,\n" +
                "            \"beDeleted\": null\n" +
                "        },\n" +
                "        \"orderItemList\": [\n" +
                "            {\n" +
                "                \"id\": null,\n" +
                "                \"orderId\": null,\n" +
                "                \"itemType\": 0,\n" +
                "                \"statusCode\": null,\n" +
                "                \"number\": 2,\n" +
                "                \"price\": 850,\n" +
                "                \"dealPrice\": 850,\n" +
                "                \"productId\": 1024,\n" +
                "                \"goodsId\": null,\n" +
                "                \"nameWithSpecifications\": null,\n" +
                "                \"picUrl\": null,\n" +
                "                \"gmtCreate\": null,\n" +
                "                \"gmtModified\": null,\n" +
                "                \"beDeleted\": null,\n" +
                "                \"product\": {\n" +
                "                    \"id\": 1024,\n" +
                "                    \"goodsId\": 274,\n" +
                "                    \"picUrl\": \"http://47.52.88.176/file/images/201612/file_5861cd259e57a.jpg\",\n" +
                "                    \"specifications\": \"default\",\n" +
                "                    \"price\": 850,\n" +
                "                    \"safetyStock\": 64,\n" +
                "                    \"gmtCreate\": \"2019-12-18T00:14:12\",\n" +
                "                    \"gmtModified\": null,\n" +
                "                    \"beDeleted\": false,\n" +
                "                    \"goods\": null\n" +
                "                }\n" +
                "            }\n" +
                "        ],\n" +
                "        \"couponId\": null,\n" +
                "        \"paymentList\": null\n" +
                "    },\n" +
                "    \"errmsg\": \"成功\"\n" +
                "}";
        Order order = JacksonUtil.parseObject(json, "data", Order.class);
    }

}
