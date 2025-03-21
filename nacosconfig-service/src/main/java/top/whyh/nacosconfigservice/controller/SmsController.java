package top.whyh.nacosconfigservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.whyh.nacosconfigservice.result.Result;
import top.whyh.nacosconfigservice.service.SmsService;

@RestController
@AllArgsConstructor
@RefreshScope
public class SmsController {
    private final SmsService smsService;

    @PostMapping("/send")
    public Result<Object> sendSms(@RequestParam("phone") String phone) {
        smsService.sendSms(phone);
        return Result.ok();
    }
}
