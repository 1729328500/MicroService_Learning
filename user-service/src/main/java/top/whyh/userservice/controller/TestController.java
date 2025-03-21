package top.whyh.userservice.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.whyh.userservice.config.WhyhProperties;

@RestController
//@RefreshScope
public class TestController {
//    @Value("${whyh.username}")
//    private String username;
//
//    @Value("${whyh.job}")
//    private String job;

    @Resource
    private WhyhProperties whyhProperties;

    @GetMapping("/test")
    public String get() {
        return "读取到用户中心的值:" + whyhProperties.getUsername() + "," + whyhProperties.getJob();
    }
}
