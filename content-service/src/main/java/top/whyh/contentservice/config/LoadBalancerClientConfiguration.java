package top.whyh.contentservice.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.ConditionalOnBlockingDiscoveryEnabled;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration(proxyBeanMethods = false)
@ConditionalOnBlockingDiscoveryEnabled
public class LoadBalancerClientConfiguration {

    private static final int REACTIVE_SERVICE_INSTANCE_SUPPLIER_ORDER = 193827465;

//    @Bean
//    @ConditionalOnMissingBean
//    public ReactorLoadBalancer<ServiceInstance> reactorServiceInstanceLoadBalancer(Environment environmentLoadBalancerClientFactory loadBalancerClientFactory) {
//        String name = e
//    }
}
