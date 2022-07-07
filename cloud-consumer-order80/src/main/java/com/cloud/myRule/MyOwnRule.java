package com.cloud.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * @program: SpringCloudTry
 * @description: Configuration for my own load-balance rule
 * @author: Siyuan
 * @create: 2022-07-05 14:48
 **/
@Configuration
public class MyOwnRule {

    /**
     * @return RestTemplate
     * @description: We should create a package that is not scanned by the main class.
     */
    @Bean
    public IRule getRestTemplate() {
        return new RandomRule(); // Use the RandomRule to load balance.
    }
}
