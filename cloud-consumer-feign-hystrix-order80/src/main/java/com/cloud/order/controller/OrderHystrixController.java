package com.cloud.order.controller;

import com.cloud.order.service.PaymentHystrixService;
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
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_Timeout(id);
        log.info("*****result: " + result);
        return result;
    }
}
