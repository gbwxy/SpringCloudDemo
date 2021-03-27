package com.atguigu.springcloud;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @auther zzyy
 * @create 2020-02-22 11:17
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;

    @PostMapping(value = "/sendMessage")
    public String sendMessage(@RequestBody Map<String, Object> map) {
        return messageProvider.send(map);
    }

}
