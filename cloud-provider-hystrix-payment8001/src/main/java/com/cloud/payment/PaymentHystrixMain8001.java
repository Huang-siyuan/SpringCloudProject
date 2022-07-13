package com.cloud.payment;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

/**
 * @program: SpringCloudTry
 * @description:
 * @author: Siyuan
 * @create: 2022-07-09 16:08
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix // This annotation has extended from @EnableCircuitBreaker.
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class, args);
    }


    /**
     * @description: Register HystrixMetricsStreamServlet to enable Hystrix dashboard.
     * The default path is not /hystrix.stream, so we need to set it by ourselves.
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        HystrixMetricsStreamServlet hystrixDashboardServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(hystrixDashboardServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
