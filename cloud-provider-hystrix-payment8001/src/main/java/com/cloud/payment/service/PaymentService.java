package com.cloud.payment.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: SpringCloudTry
 * @description: We should create an interface then implement it. But this part just
 * for demo. So we just do it directly.
 * @author: Siyuan
 * @create: 2022-07-09 16:08
 **/

@Service
@Slf4j
public class PaymentService {

    /**
     * Normally access, must successfully return a String.
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "Thread pool:" + Thread.currentThread().getName() + " paymentInfo_OK, id: " + id + "\t" + "OK";
    }

    /**
     * @param id
     * @return
     * @description: @HystrixCommand can help us to make this method fallback. 3s is the normal time.
     * It's a limit. If overtime or throws exceptions, then Hystrix will call the fallback method.
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")})
    public String paymentInfo_Timeout(Integer id) {
        log.info("Begin to throw Exception");
//        int age = 10 / 0;
        log.info("End of throw Exception"); // Well, looks like program won't be this line. Hystrix will call the fallback method.
        int timeNumber = 5000;
        try {
            Thread.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Thread pool:" + Thread.currentThread().getName() + " paymentInfo_Timeout, id: " + id + "\t" + "Spent " + timeNumber + "ms";
    }

    // If overtime, we will run this.
    public String paymentInfo_TimeoutHandler(Integer id) {
        return "Server is busy or service can't be used, please try again later, id: " + id;
    }

    // Service circuit breaker
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {@HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // Enable circuit breaker
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // If 10 requests in 10s, then open the circuit
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 10s, then close the circuit. Default is 5s.
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // If 60% requests are failed, then open the circuit
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            log.error("*****id should less than 0");
            throw new RuntimeException("*****id should less than 0");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + ": PaymentCircuitBreaker, id: " + id + "\t serialNumber: " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "Id shouldn't be negative, id: " + id;
    }
}
