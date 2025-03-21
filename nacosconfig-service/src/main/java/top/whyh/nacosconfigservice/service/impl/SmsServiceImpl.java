package top.whyh.nacosconfigservice.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.whyh.nacosconfigservice.config.RedisKeys;
import top.whyh.nacosconfigservice.service.SmsService;
import top.whyh.nacosconfigservice.config.RedisCache;
import top.whyh.nacosconfigservice.util.CommonUtils;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

/**
 * @author mqxu
 * @date 2024/10/21
 * @description SmsServiceImpl
 **/
@Service
@Slf4j
@AllArgsConstructor
public class SmsServiceImpl implements SmsService {

    private final RedisCache redisCache;

    @Override
    public void sendSms(String phone) {
        int code = CommonUtils.generateCode();
        redisCache.set(RedisKeys.getSmsKey(phone), code, 60);
        log.info(" ============= 短信发送成功 ============= ");
        // 调用内部方法发送短信
//        boolean result = send(phone, code);
//        if (result) {
//            log.info(" ============= 短信发送成功 ============= ");
//        }
    }
}
