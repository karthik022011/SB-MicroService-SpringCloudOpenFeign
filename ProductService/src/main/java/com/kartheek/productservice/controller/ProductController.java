package com.kartheek.productservice.controller;

import com.kartheek.productservice.model.ProductDetailsResDTO;
import com.kartheek.productservice.model.ProductReqDTO;
import com.kartheek.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/product")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductReqDTO productReqDTO) {
      long id =  productService.addProduct(productReqDTO);
      return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDetailsResDTO> getProductById(@PathVariable("productId") long productId) {
        ProductDetailsResDTO productDetailsResDTO = productService.getProductById(productId);
        return ResponseEntity.ok(productDetailsResDTO);
    }
}

//http://localhost:8083/api/v1/product
/*{
    "productName":"Choclate",
     "price":1
}*/
