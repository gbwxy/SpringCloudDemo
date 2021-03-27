package com.atguigu.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {
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

    @RequestMapping(value = "/payment/consul")
    public String paymentConsul() {
        return "springcloud with consul: " + serverPort + "\t   " + UUID.randomUUID().toString();
    }
}
