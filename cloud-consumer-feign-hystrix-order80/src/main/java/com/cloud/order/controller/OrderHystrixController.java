package com.cloud.order.controller;

import com.cloud.order.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringCloudTry
 * @author: Siyuan
 * @create: 2022-07-10 19:11
 **/
@RestController
@Slf4j
@AllArgsConstructor
public class OrderHystrixController {
    private final PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_OK(id);
        log.info("*****result: " + result);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_Timeout_fallback", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")})
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        int age = 10 / 0;
        String result = paymentHystrixService.paymentInfo_Timeout(id);
        log.info("*****result: " + result);
        return result;
    }

    public String paymentInfo_Timeout_fallback(@PathVariable("id") Integer id) {
        log.info("fallback: " + id);
        return "Server(consumer80) is busy or service can't be used, please try again later, id: " + id;
    }
}
