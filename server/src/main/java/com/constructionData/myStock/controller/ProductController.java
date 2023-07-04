package com.constructionData.myStock.controller;

import com.constructionData.myStock.model.DTO.ProductDTO;
import com.constructionData.myStock.service.ProductService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.Set;


@RestController
@CrossOrigin(origins = "https://mystock-frontend.onrender.com")
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findProductById(@PathVariable Long id) {
        ProductDTO product = productService.getProductById(id);
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

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<ProductDTO>> violations = validator.validate(newProduct);

        if (violations.isEmpty()) {
            // DTO is valid, proceed with further operations
            ProductDTO createdProduct = productService.createProduct(newProduct);
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
        } else {
            StringBuilder errorMessage = new StringBuilder();
            // Handle validation failures
            for (ConstraintViolation<ProductDTO> violation : violations) {
                String propertyPath = violation.getPropertyPath().toString();
                String message = violation.getMessage();
                errorMessage.append("Validation error: ").append(propertyPath).append(" - ").append(message).append("\n");
            }
            return new ResponseEntity<>(errorMessage.toString(), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO updatedProduct) {
        Optional<ProductDTO> optionalProduct = Optional.ofNullable(productService.getProductById(id));
        if (optionalProduct.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            ProductDTO existingProduct = optionalProduct.get();
            ProductDTO updatedDatabaseProduct = productService.updateProduct(existingProduct, updatedProduct);
            return new ResponseEntity<>(updatedDatabaseProduct, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Long id) {
        boolean isDeleted = productService.deleteProduct(id);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
