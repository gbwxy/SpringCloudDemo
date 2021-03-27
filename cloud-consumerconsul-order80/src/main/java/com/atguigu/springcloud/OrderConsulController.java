package com.atguigu.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @auther zzyy
 * @create 2020-02-19 16:24
 */
@RestController
@Slf4j
public class OrderConsulController
{
    public static final String INVOKE_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String serverPort;
    @Value("${spring.application.name}")
    private String appName;
    @Value("${spring.cloud.client.ip-address}")
    private String ipAddr;

    @RequestMapping("/actuator/health")
    public String home() {
        return appName + "-" + ipAddr + "-" + serverPort;
    }


    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo()
    {
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
        return result;
    }
}
