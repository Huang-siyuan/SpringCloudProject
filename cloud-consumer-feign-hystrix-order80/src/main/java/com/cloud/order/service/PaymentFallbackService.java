package com.cloud.order.service;

import org.springframework.stereotype.Service;

/**
 * @program: SpringCloudTry
 * @description: Fallback for all feign method in interface.
 * @author: Siyuan
 * @create: 2022-07-11 10:37
 **/

@Service
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "Fallback paymentInfo_OK, id: " + id;
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "Fallback paymentInfo_Timeout, id: " + id;
    }
}

