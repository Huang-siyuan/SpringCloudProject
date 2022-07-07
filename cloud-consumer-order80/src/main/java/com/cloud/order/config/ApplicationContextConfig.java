package com.cloud.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: SpringCloudTry
 * @description: Configuration for RestTemplate
 * @author: Siyuan
 * @create: 2022-05-17 16:20
 **/
@Configuration
public class ApplicationContextConfig {

    /**
     * @return RestTemplate
     * @description: RestTemplate bean. We can use this bean to send http request to call payment service.
     *               And @loadBalanced annotation is used to make the RestTemplate load balance.
     *               The default algorithm is round-robin. And we can choose other algorithm like: random, leastActive, etc.
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
