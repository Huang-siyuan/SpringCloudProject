package com.cloud.feign.service;

import com.cloud.api.DTO.CommonResult;
import com.cloud.api.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

/**
 * @program: SpringCloudTry
 * @description:
 * @author: Siyuan
 * @create: 2022-07-07 22:46
 * @description: @FeignClient can let us use service name to call the service which has already registered.
 */

@Service
@FeignClient("CLOUD-PAYMENT-SERVICE")
@RequestMapping("/paymentRecord")
public interface PaymentFeignService {

    @GetMapping("/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/feign/timeout")
    String paymentFeignTimeout();
}
