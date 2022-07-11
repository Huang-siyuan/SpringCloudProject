package com.cloud.payment.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
