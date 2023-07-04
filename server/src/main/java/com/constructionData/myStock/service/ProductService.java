package com.constructionData.myStock.service;

import com.constructionData.myStock.model.DTO.ProductDTO;
import com.constructionData.myStock.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Product with id " + id + " is not found" +
                        "."));
    }

    public boolean deleteProduct(Long id) {
        Optional<ProductDTO> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            return true; // Deletion successful
        } else {
            return false; // Deletion failed
        }
    }

    public ProductDTO createProduct(ProductDTO newProduct) {
        newProduct.setTimeOfRecord(LocalDateTime.now()); // timeOfRecord is added here!
        return productRepository.save(newProduct);
    }

    public ProductDTO updateProduct(ProductDTO existingProduct, ProductDTO updatedProductDTO) {
//
        Field[] fields = updatedProductDTO.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object updatedValue = field.get(updatedProductDTO);
                if (updatedValue != null && !isZero(updatedValue)) {
                    Field existingField = existingProduct.getClass().getDeclaredField(field.getName());
                    existingField.setAccessible(true);
                    existingField.set(existingProduct, updatedValue);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // Handle any exceptions that may occur
                e.printStackTrace();
            }
        }

        existingProduct.setLastTimeOfModified(LocalDateTime.now());

        // Save the updated entity
        return productRepository.save(existingProduct);
    }

    private boolean isZero(Object value) {
        if (value instanceof Number numberValue) {
            if (numberValue instanceof Double || numberValue instanceof Float) {
                return numberValue.doubleValue() == 0.0;
            } else {
                return numberValue.longValue() == 0;
            }
        }
        return false;
    }

}
