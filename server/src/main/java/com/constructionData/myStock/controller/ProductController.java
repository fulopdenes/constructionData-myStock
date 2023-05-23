package com.constructionData.myStock.controller;

import com.constructionData.myStock.model.DTO.ProductDTO;
import com.constructionData.myStock.model.Product;
import com.constructionData.myStock.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = {"http://192.168.0.17:3000", "http://localhost:3000"})
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // TODO: write test of each endpoints with all kind of scenarios: or desired result or relevant httpResponse.

    @GetMapping("/all")
    public List<Product> getAllProducts() {return productService.getAllProducts();}

    @GetMapping("/get/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product.getId() != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO newProduct) {
        Product createdProduct = productService.createProduct(newProduct);
        // TODO: if product parameters are not proper, then should inform the client what parameters are
        //  missing or obligatory.
        if (createdProduct != null) {
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductDTO updatedProduct) {
        Optional<Product> optionalProduct = Optional.ofNullable(productService.getProductById(id));
        if (optionalProduct.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Product product = optionalProduct.get();
            Product updatedDatabaseProduct = productService.updateProduct(product, updatedProduct);
            return new ResponseEntity<>(updatedDatabaseProduct, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Product existingProduct = productService.getProductById(id);

        if (existingProduct == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            productService.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
