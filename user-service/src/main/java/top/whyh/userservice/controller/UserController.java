package top.whyh.userservice.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Resource
    private RestTemplate restTemplate;  // 确保使用注入的实例

    @GetMapping("/user")
    public String getUser(@RequestParam String username) {
//        // 使用服务名调用（确保无硬编码地址）
//        String aiResponse = restTemplate.getForObject(
//                "http://localhost:8084/ask?question=请生成用户" + username + "的欢迎语",
//                String.class
//        );
//        return "User: " + username + "\nAI 问候: " + aiResponse;

        // 使用服务名调用（确保无硬编码地址）
        String aiResponse = restTemplate.getForObject(
                "http://localhost:8085/ask?question=请生成用户" + username + "的欢迎语",
                String.class
        );
        return "User: " + username + "\nNode.js: " + aiResponse;
    }
}