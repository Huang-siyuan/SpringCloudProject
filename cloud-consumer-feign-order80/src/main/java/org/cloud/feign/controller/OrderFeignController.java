package org.cloud.feign.controller;

import com.cloud.api.DTO.CommonResult;
import com.cloud.api.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cloud.feign.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringCloudTry
 * @author: Siyuan
 * @create: 2022-07-07 22:56
 **/
@RestController
@Slf4j
@AllArgsConstructor
public class OrderFeignController {
    private final PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        log.info("Trying to get payment {} by openfeign.", id);
        return paymentFeignService.getPaymentById(id);
    }
}
