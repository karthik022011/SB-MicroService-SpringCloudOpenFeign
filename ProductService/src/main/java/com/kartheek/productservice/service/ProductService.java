package com.kartheek.productservice.service;

import com.kartheek.productservice.model.ProductDetailsResDTO;
import com.kartheek.productservice.model.ProductReqDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductService {
    long addProduct(ProductReqDTO productReqDTO);

    ProductDetailsResDTO getProductById(long productId);
}
