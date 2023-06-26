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
@CrossOrigin(origins = "https://mystock-frontend.onrender.com")
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO newProduct) {
        if (newProduct == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (newProduct.getProductName() == null
                || newProduct.getRelatedUnit() == null
                || newProduct.getCategory() == null
                || newProduct.getQuantityType() == null
                || newProduct.getQuantity() == null
                || newProduct.getProductTechCode() == null
                || newProduct.getRoomNameOfInstallation() == null
        ) {
            String errorMessage = "The following parameters are missing or invalid: ";
            if (newProduct.getProductName() == null) {
                errorMessage += "ProductName ";
            }

            if (newProduct.getRelatedUnit() == null) {
                errorMessage += "RelatedUnit ";
            }

            if (newProduct.getCategory() == null) {
                errorMessage += "Category ";
            }

            if (newProduct.getQuantityType() == null) {
                errorMessage += "QuantityType ";
            }
            if (newProduct.getQuantity() == null) {
                errorMessage += "Quantity ";
            }
            if (newProduct.getProductTechCode() == null) {
                errorMessage += "ProductTechCode ";
            }
            if (newProduct.getRoomNameOfInstallation() == null) {
                errorMessage += "RoomNameOfInstallation ";
            }
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }

        Product createdProduct = productService.createProduct(newProduct);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
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
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Long id) {
        boolean isDeleted = productService.deleteProduct(id);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }



}
