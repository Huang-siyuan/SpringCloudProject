package com.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * @author Siyuan
 * @create 2022-05-17-11:26
 */
@SpringBootApplication
public class OrderMain80 {
    public static void main(String[] args) {
        System.getProperties().put("server.port", 80);
        SpringApplication.run(OrderMain80.class, args);
    }
}
