package top.whyh.requestservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class AndroidController2 {
    private final String SERVICE_Url="https://www.wanandroid.com";

    private final WebClient webClient = WebClient.builder().baseUrl(SERVICE_Url).build();

    @GetMapping("/webClientTest1")
    public String webClientTest() {
        // 使用 block() 直接获取响应内容并返回
        return webClient
                .get()
                .uri("/harmony/index/json")
                .retrieve()
                .bodyToMono(String.class)
                .block(); // 注意：仅用于演示，生产环境不推荐使用 block()
    }
}