package com.constructionData.myStock.service;

import com.constructionData.myStock.model.DTO.ProductDTO;
import com.constructionData.myStock.model.Product;
import com.constructionData.myStock.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Product id is not found."));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product createProduct(Product newProduct) {
        Product createdNewProduct = Product.builder()
                // TODO: newProductId how will be generated?
                .productName(newProduct.getProductName())
                .productTechCode(newProduct.getProductTechCode())
                .category(newProduct.getCategory())
                .deliveryNoteID(newProduct.getDeliveryNoteID())
                .deliveryType(newProduct.getDeliveryType())
                .placeOfStorage(newProduct.getPlaceOfStorage())
                .quantityType(newProduct.getQuantityType())
                .relatedUnit(newProduct.getRelatedUnit())
                .roomPlanCode(newProduct.getRoomPlanCode())
                .category(newProduct.getCategory())
                .timeOfRecord(LocalDateTime.now())
                .lastTimeOfModified(LocalDateTime.now())
                .build();

        return productRepository.save(createdNewProduct);
    }

    public Product updateProduct(ProductDTO updatedProductDTO) {

        Product underUpdateProduct = Product.builder()
                .productName(updatedProductDTO.productName())
                .productTechCode(updatedProductDTO.productTechCode())
                .quantity(updatedProductDTO.quantity())
                .relatedUnit(updatedProductDTO.relatedUnit())
                .quantityType(updatedProductDTO.quantityType())
                .category(updatedProductDTO.category())
                .lastTimeOfModified(LocalDateTime.now()) // It is defined at LocalDateTimeNow.
                .deliveryNoteID(updatedProductDTO.deliveryNoteID())
                .placeOfStorage(updatedProductDTO.placeOfStorage())
                .roomPlanCode(updatedProductDTO.roomPlanCode())
                .deliveryType(updatedProductDTO.deliveryType())
                .build();

        return productRepository.save(underUpdateProduct);
    }
}
