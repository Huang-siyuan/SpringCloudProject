package com.cloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Siyuan
 * @create 2022-05-16-15:34
 */
@SpringBootApplication
public class PaymentMain8001 {
    public static void main(String[] args) {
        System.getProperties().put( "server.port", 8001);
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
