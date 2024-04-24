package com.kartheek.orderservice.external.client;


import com.kartheek.orderservice.external.response.ProductDetailsResDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCT-SERVICE", url = "http://localhost:8083/api/v1/product")
public interface ProductServiceAPIClient {
    @GetMapping("/{productId}")
    public ProductDetailsResDTO getProductById(@PathVariable("productId") long productId);
}
