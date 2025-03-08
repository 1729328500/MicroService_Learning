package top.whyh.userservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "whyh")
@Data
public class WhyhProperties {
    private Boolean serviceFlag;
}
