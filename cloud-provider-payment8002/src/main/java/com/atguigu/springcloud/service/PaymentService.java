package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * @Description TODO
 * @Author xwz
 * @Date 2020/4/25 9:53
 * @Version 1.0
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
