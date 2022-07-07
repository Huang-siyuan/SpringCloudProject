package com.cloud.order.controller;

import com.cloud.api.DTO.CommonResult;
import com.cloud.api.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @program: SpringCloudTry
 * @description: Controller for ordering
 * @author: Siyuan
 * @create: 2022-05-17 14:29
 **/

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/consumer")
public class OrderController {

    // We can get the servise from eureka server by name. It can keep the load balance.
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/";

    private final RestTemplate restTemplate;

    @PostMapping("/payment")
    public CommonResult create(@RequestBody Payment payment) {
        log.info("create payment in consumer: {}", payment);
        return restTemplate.postForObject(PAYMENT_URL, payment, CommonResult.class);
    }

    @GetMapping("/payment/{id}")
    public CommonResult getPayment(@PathVariable Long id) {
        log.info("get payment in consumer: {}", id.toString());
        return restTemplate.getForObject(PAYMENT_URL + "paymentRecord/" + id, CommonResult.class);
    }

    // A test for function getForEntity().
    @GetMapping("/payment/forEntity/{id}")
    public CommonResult getPayment2(@PathVariable Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "paymentRecord/" + id, CommonResult.class);

        if (entity.getStatusCode().is2xxSuccessful()) {
            log.info("get payment in consumer: {}", entity.getBody().toString());
            return entity.getBody();
        } else {
            return new CommonResult<>(500, "error");
        }
    }

}
