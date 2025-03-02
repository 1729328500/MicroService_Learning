package top.whyh.requestservice.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AndroidController {
    @Resource
    private RestTemplate restTemplate;

    private final String SERVICE_Url="https://www.wanandroid.com";

    @GetMapping("/restTemplate1")
    public String consumerRestTemplate() {
        return restTemplate.getForObject(SERVICE_Url+"/article/list/0/json",String.class);
    }
}

