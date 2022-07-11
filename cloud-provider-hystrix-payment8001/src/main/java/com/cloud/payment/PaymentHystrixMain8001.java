package com.cloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @program: SpringCloudTry
 * @description:
 * @author: Siyuan
 * @create: 2022-07-09 16:08
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix // This annotation has extended from @EnableCircuitBreaker.
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class, args);
    }
}
