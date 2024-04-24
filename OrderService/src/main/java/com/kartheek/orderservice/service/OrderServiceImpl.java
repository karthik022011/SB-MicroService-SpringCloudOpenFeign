package com.kartheek.orderservice.service;

import com.microservice.orderservice.entity.Order;
import com.microservice.orderservice.external.client.ProductServiceClient;
import com.microservice.orderservice.external.response.ProductDetailsResDTO;
import com.microservice.orderservice.model.OrderReqDtO;
import com.microservice.orderservice.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductServiceClient productServiceClient;

    @Override
    public long placeOrder(OrderReqDtO orderReqDtO) {
        //fetch product info
        ProductDetailsResDTO product = productServiceClient.getProductById(orderReqDtO.getProductId());

        Order order = new Order();
        order.setProductId(product.getProductId());
        order.setProductName(product.getProductName());
        order.setTotalAmount(product.getPrice());

        Order savedOrder = orderRepository.save(order);
        return savedOrder.getOrderId();
    }
}
