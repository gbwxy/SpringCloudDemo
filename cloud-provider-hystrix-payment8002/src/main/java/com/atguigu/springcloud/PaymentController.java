package com.atguigu.springcloud;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    @Value("${spring.application.name}")
    private String appName;
    @Value("${spring.cloud.client.ip-address}")
    private String ipAddr;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        result = result + "---【" + ipAddr + "-" + appName + "-" + serverPort + "】";
        log.info("*****result: " + result);
        return result;
    }


    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        result = result + "---【" + ipAddr + "-" + appName + "-" + serverPort + "】";
        log.info("*****result: " + result);
        return result;
    }

    //====服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        result = result + "---【" + ipAddr + "-" + appName + "-" + serverPort + "】";
        log.info("****result: " + result);
        return result;
    }
}
