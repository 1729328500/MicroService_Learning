package top.whyh.nacosconfigservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.whyh.nacosconfigservice.mapper") // 添加Mapper扫描配置
public class NacosconfigServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosconfigServiceApplication.class, args);
    }
}
