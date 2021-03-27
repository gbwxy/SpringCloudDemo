package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 描述：
 *
 * @Author wangjun
 * @Date 2021/3/3
 */
@SpringBootApplication
@EnableFeignClients
public class OrderMainFeignZk80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainFeignZk80.class, args);
    }
}
