package com.kartheek.productservice.service;

import com.kartheek.productservice.entity.Product;
import com.kartheek.productservice.model.ProductDetailsResDTO;
import com.kartheek.productservice.model.ProductReqDTO;
import com.kartheek.productservice.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl  implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public long addProduct(ProductReqDTO productReqDTO) {
        Product product = modelMapper.map(productReqDTO, Product.class);
        Product savedProduct = productRepository.save(product);
        return savedProduct.getProductId();
    }

    @Override
    public ProductDetailsResDTO getProductById(long productId) {
        Product product = productRepository.findById(productId).get();
        return modelMapper.map(product, ProductDetailsResDTO.class);
    }
}
