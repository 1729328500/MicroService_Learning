package top.whyh.helloservice.service;

import org.springframework.stereotype.Service;

@Service

public class HelloService {
    public String getName() {
        return "Hello";
    }

    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }
}
