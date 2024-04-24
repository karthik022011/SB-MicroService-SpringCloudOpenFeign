package com.kartheek.orderservice.service;


import com.kartheek.orderservice.entity.Order;
import com.kartheek.orderservice.external.client.ProductServiceAPIClient;
import com.kartheek.orderservice.external.response.ProductDetailsResDTO;
import com.kartheek.orderservice.model.OrderReqDtO;
import com.kartheek.orderservice.repository.OrderRepository;
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
    private ProductServiceAPIClient productServiceAPIClient;

    @Override
    public long placeOrder(OrderReqDtO orderReqDtO) {
        //fetch product info
        ProductDetailsResDTO product = productServiceAPIClient.getProductById(orderReqDtO.getProductId());

        Order order = new Order();
        order.setProductId(product.getProductId());
        order.setProductName(product.getProductName());
        order.setTotalAmount(product.getPrice());

        Order savedOrder = orderRepository.save(order);
        return savedOrder.getOrderId();
    }
}
