package com.xmu.wowoto.wowomall.controller;

import com.xmu.wowoto.wowomall.util.JacksonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
/*
@SpringBootTest
public class GetOrders {
    @Value("http://${oomall.host}:${oomall.host}/adService/ads/{id}")
    String url;

    @Autowired
    private TestRestTemplate testRestTemplate;

/*
    private HttpHeaders getHttpHeaders(URI uri) throws URISyntaxException {
        HttpHeaders httpHeaders = testRestTemplate.headForHeaders(uri);
        if (!adminAccount.addToken(httpHeaders)) {
            //登录失败
            assertTrue(false);
        }
        return httpHeaders;
    }
*/
    /*********************************************************
     * DELETE
     *********************************************************/
    /**
     * @author fringe
     */
    /*
    @Test
    public void tc_getOrders_001() throws Exception {
        /* 设置请求头部*/
    /*
        URI uri = new URI(url.replace("{id}", "121"));
        HttpHeaders httpHeaders = getHttpHeaders(uri);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<String> response = this.testRestTemplate.exchange(uri, HttpMethod.DELETE, httpEntity, String.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);

        response = this.testRestTemplate.getForEntity(url, String.class);
        String body = response.getBody();
        Integer errNo = JacksonUtil.parseInteger(body, "errno");
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(680, errNo);
    }

}
*/
