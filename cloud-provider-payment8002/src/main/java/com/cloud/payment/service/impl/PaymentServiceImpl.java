package com.cloud.payment.service.impl;

import com.cloud.api.DTO.CommonResult;
import com.cloud.api.entity.Payment;
import com.cloud.payment.DAO.PaymentDao;
import com.cloud.payment.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @program: SpringCloudTry
 * @description: Implemention of service
 * @author: Siyuan
 * @create: 2022-05-16 17:32
 **/
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private final PaymentDao paymentDao;

    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Value("${server.port}")
    private String serverPort;

    public CommonResult<Integer> create(Payment payment) {
        int result = paymentDao.create(payment);
        log.info("Result of inserting: " + result);

        if (result > 0) {
            return new CommonResult<>(200, "Insert Success by port " + serverPort, result);
        } else {
            return new CommonResult<>(444, "Insert Failed", null);
        }
    }

    public CommonResult<Payment> getPaymentById(Long id) {
        Payment payment = paymentDao.getPaymentById(id);
        log.info("Result of inserting: " + payment.toString());
        if (payment.getId() != null) {
            return new CommonResult<>(200, "Select successfully by port " + serverPort, payment);
        } else {
            return new CommonResult<>(444, "Select Failed", null);
        }
    }
}
