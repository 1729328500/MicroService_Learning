package top.whyh.nacosconfigservice.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Getter
@Component
@RefreshScope
public class DeepSeekConfig {

    @Value("${deepseek.api.key}")
    private String apiKey;

    // 修改: 将 ${deepseek.api.url} 改为 ${deepseek.api.base-url}
    @Value("${deepseek.api.base-url}")
    private String apiUrl;

}