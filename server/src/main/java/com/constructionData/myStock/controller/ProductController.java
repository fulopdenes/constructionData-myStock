package com.constructionData.myStock.controller;

import com.constructionData.myStock.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // POST /products
    // GET /products/{id}
    // PUT /products/{id}
    // DELETE /products/{id}

}
