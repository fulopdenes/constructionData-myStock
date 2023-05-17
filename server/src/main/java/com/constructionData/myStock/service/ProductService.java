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
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Product with id " + id + " is not found" +
                        "."));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product createProduct(ProductDTO newProduct) {

        Product createdNewProduct = Product.builder()
                // TODO: newProductId how will be generated?
                // TODO: define when and what kind of data will be added to this entity
                .productName(newProduct.productName())
                .productTechCode(newProduct.productTechCode())
                .category(newProduct.category())
                .deliveryNoteID(newProduct.deliveryNoteID())
                .deliveryType(newProduct.deliveryType())
                .placeOfStorage(newProduct.placeOfStorage())
                .quantityType(newProduct.quantityType())
                .relatedUnit(newProduct.relatedUnit())
                .roomPlanCode(newProduct.roomPlanCode())
                .category(newProduct.category())
                .timeOfRecord(LocalDateTime.now()) // the timeOfRecord is defined at this moment.
                .lastTimeOfModified(LocalDateTime.now()) // the lastTimeOfModified is defined at this moment.
                .quantity(newProduct.quantity())
                .roomNameOfInstallation(newProduct.roomNameOfInstallation())
                .timeOfOrder(newProduct.timeOfOrder())
                .timeOfArrivedAtSite(newProduct.timeOfArrivedAtSite())
                .timeOfInstalled(newProduct.timeOfInstalled())
                .build();

        return productRepository.save(createdNewProduct);
    }

    public Product updateProduct(Product existingProduct, ProductDTO updatedProductDTO) {

        // Apply partial update to the entity
        if (updatedProductDTO.productName() != null) {
            existingProduct.setProductName(updatedProductDTO.productName());
        }
        if (updatedProductDTO.productTechCode() != null) {
            existingProduct.setProductTechCode(updatedProductDTO.productTechCode());
        }
        if (updatedProductDTO.quantity() != null) {
            existingProduct.setQuantity(updatedProductDTO.quantity());
        }
        if (updatedProductDTO.relatedUnit() != null) {
            existingProduct.setRelatedUnit(updatedProductDTO.relatedUnit());
        }
        if (updatedProductDTO.quantityType() != null) {
            existingProduct.setQuantityType(updatedProductDTO.quantityType());
        }
        if (updatedProductDTO.category() != null) {
            existingProduct.setCategory(updatedProductDTO.category());
        }

        existingProduct.setLastTimeOfModified(LocalDateTime.now()); // It is defined at LocalDateTimeNow.

        if (updatedProductDTO.deliveryNoteID() != null) {
            existingProduct.setDeliveryNoteID(updatedProductDTO.deliveryNoteID());
        }
        if (updatedProductDTO.placeOfStorage() != null) {
            existingProduct.setPlaceOfStorage(updatedProductDTO.placeOfStorage());
        }
        if (updatedProductDTO.roomPlanCode() != null) {
            existingProduct.setRoomPlanCode(updatedProductDTO.roomPlanCode());
        }
        if (updatedProductDTO.deliveryType() != null) {
            existingProduct.setDeliveryType(updatedProductDTO.deliveryType());
        }
        if (updatedProductDTO.roomNameOfInstallation() != null) {
            existingProduct.setRoomNameOfInstallation(updatedProductDTO.roomNameOfInstallation());
        }
        if (updatedProductDTO.timeOfInstalled() != null) {
            existingProduct.setTimeOfInstalled(updatedProductDTO.timeOfInstalled());
        }
        if (updatedProductDTO.timeOfArrivedAtSite() != null) {
            existingProduct.setTimeOfArrivedAtSite(updatedProductDTO.timeOfArrivedAtSite());
        }
        if (updatedProductDTO.timeOfOrder() != null) {
            existingProduct.setTimeOfOrder(updatedProductDTO.timeOfOrder());
        }
        // TODO: replace static conditions with EntityMapper

        // Save the updated entity
        return productRepository.save(existingProduct);
    }
}
