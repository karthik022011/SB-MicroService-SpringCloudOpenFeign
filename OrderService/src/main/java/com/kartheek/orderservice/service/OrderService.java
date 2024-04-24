package com.kartheek.orderservice.service;

import com.microservice.orderservice.model.OrderReqDtO;

public interface OrderService {
    long placeOrder(OrderReqDtO orderReqDtO);
}
