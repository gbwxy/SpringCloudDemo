package com.atguigu.springcloud.service;

import java.util.Map;

/**
 * @auther zzyy
 * @create 2020-02-22 10:55
 */
public interface IMessageProvider {
    String send(Map<String, Object> map);
}
