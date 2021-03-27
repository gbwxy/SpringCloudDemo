package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther zzyy
 * @create 2020-02-23 17:02
 */
@RestController
@RefreshScope //支持Nacos的动态刷新功能。
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @Value("${config.namespace}")
    private String namespace;

    @Value("${config.group}")
    private String group;

    @Value("${config.name}")
    private String name;

    @Value("${mysql.ip}")
    private String mysqlIP;
    @Value("${mysql.port}")
    private String mysqlPort;


    @GetMapping("/config/info")
    public String getConfigInfo() {
        String str = String.format(mysqlIP + ":" + mysqlPort + "-" + "info :" + configInfo + "*****" +
                namespace + "-" + group + "--" + name);
        return str;
    }
}
