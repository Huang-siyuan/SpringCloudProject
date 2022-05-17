package com.cloud.payment.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: SpringCloudTry
 * @author: Siyuan
 * @create: 2022-05-16 17:05
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T      data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
