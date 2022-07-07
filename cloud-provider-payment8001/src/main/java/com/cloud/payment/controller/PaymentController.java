package com.cloud.payment.controller;

import com.cloud.api.DTO.CommonResult;
import com.cloud.api.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import com.cloud.payment.service.PaymentService;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @program: SpringCloudTry
 * @description: Controller for Payment
 * @author: Siyuan
 * @create: 2022-05-16 17:37
 **/

@RestController
@RequestMapping("/paymentRecord")
@AllArgsConstructor
@Slf4j
public class PaymentController {
    private final PaymentService paymentService;
    private final DiscoveryClient discoveryClient;

    @PostMapping("/")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        log.info("Received request of creating: " + payment);
        return paymentService.create(payment);
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/test")
    public String test() {
        return "Hello test";
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("****element: " + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping("/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3); // For timeout test
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "8001";
    }
}
