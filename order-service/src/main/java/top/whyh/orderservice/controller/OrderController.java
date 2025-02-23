package top.whyh.orderservice.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/order")
    public String createOrder(@RequestParam String username, @RequestParam String productId){
        String userServiceUrl = "http://localhost:8081/user?username=" +username;
        String serviceUrl = "http://localhost:8083/products?productId=" +productId;
        String productInfo = restTemplate.getForObject(serviceUrl,String.class);
        String userinfo = restTemplate.getForObject(userServiceUrl,String.class);
        return "订单的创建者是:" +userinfo + "当前信息:" + productInfo;
    }
}
