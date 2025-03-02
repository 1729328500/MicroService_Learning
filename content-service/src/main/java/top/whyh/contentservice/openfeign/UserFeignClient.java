package top.whyh.contentservice.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.whyh.contentservice.vo.UserVO;


@FeignClient(name = "user-service")
public interface UserFeignClient {
    @GetMapping("/user/{id}")
    UserVO getUserById(@PathVariable Integer id);
}