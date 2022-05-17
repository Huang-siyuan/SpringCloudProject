package com.cloud.payment.controller;

import com.cloud.payment.DTO.CommonResult;
import com.cloud.payment.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.cloud.payment.service.PaymentService;

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

    @PostMapping("/")
    public CommonResult<Integer> create(Payment payment){
        return paymentService.create(payment);
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/test")
    public String test(){
        return "Hello test";
    }

}
