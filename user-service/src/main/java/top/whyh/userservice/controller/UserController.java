package top.whyh.userservice.controller;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import top.whyh.userservice.config.WhyhProperties;
import top.whyh.userservice.entity.User;
import top.whyh.userservice.service.UserService;
import top.whyh.userservice.config.ApiResponse;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable Integer id) {
        ApiResponse response = userService.getFullUserById(id);
        return ResponseEntity.status(response.getCode()).body(response);
    }


    @Resource
    private RestTemplate restTemplate;  // 确保使用注入的实例
    private WhyhProperties whyhProperties;

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