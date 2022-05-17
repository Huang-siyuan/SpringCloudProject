package com.cloud.payment.service;

import com.cloud.payment.DTO.CommonResult;
import com.cloud.payment.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @program: SpringCloudTry
 * @description: Payment service
 * @author: Siyuan
 * @create: 2022-05-16 17:24
 **/
public interface PaymentService {
    CommonResult<Integer> create(Payment payment);

    CommonResult<Payment> getPaymentById(@Param("id") Long id);
}
