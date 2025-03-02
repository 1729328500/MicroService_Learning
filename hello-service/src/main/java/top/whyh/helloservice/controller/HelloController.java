package top.whyh.helloservice.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.whyh.helloservice.service.HelloService;

@RestController
public class HelloController {
@Resource
    private HelloService helloService;

@GetMapping("/hello")
    public String hello(){
    return "Hello" + helloService.getName();
}
    @GetMapping("/sayHello")
    public String sayHello(@RequestParam String name){
        return "Hello" + helloService.sayHello(name);
    }

}
