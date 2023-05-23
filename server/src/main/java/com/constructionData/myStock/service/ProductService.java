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
                // TODO: define when and what kind of data will be added to this entity
                .productName(newProduct.getProductName())
                .productTechCode(newProduct.getProductTechCode())
                .category(newProduct.getCategory())
                .deliveryNoteID(newProduct.getDeliveryNoteID())
                .deliveryType(newProduct.getDeliveryType())
                .placeOfStorage(newProduct.getPlaceOfStorage())
                .quantityType(newProduct.getQuantityType())
                .relatedUnit(newProduct.getRelatedUnit())
                .roomPlanCode(newProduct.getRoomPlanCode())
                .timeOfRecord(LocalDateTime.now()) // the timeOfRecord is defined at this moment.
                .lastTimeOfModified(LocalDateTime.now()) // the lastTimeOfModified is defined at this moment.
                .quantity(newProduct.getQuantity())
                .roomNameOfInstallation(newProduct.getRoomNameOfInstallation())
                .timeOfOrder(newProduct.getTimeOfOrder())
                .timeOfArrivedAtSite(newProduct.getTimeOfArrivedAtSite())
                .timeOfInstalled(newProduct.getTimeOfInstalled())
                .build();

        return productRepository.save(createdNewProduct);
    }

    public Product updateProduct(Product existingProduct, ProductDTO updatedProductDTO) {

        // Apply partial update to the entity
        if (updatedProductDTO.getProductName() != null) {
            existingProduct.setProductName(updatedProductDTO.getProductName());
        }
        if (updatedProductDTO.getProductName() != null) {
            existingProduct.setProductTechCode(updatedProductDTO.getProductTechCode());
        }
        if (updatedProductDTO.getProductName() != null) {
            existingProduct.setQuantity(updatedProductDTO.getQuantity());
        }
        if (updatedProductDTO.getProductTechCode() != null) {
            existingProduct.setRelatedUnit(updatedProductDTO.getRelatedUnit());
        }
        if (updatedProductDTO.getQuantityType() != null) {
            existingProduct.setQuantityType(updatedProductDTO.getQuantityType());
        }
        if (updatedProductDTO.getCategory() != null) {
            existingProduct.setCategory(updatedProductDTO.getCategory());
        }

        existingProduct.setLastTimeOfModified(LocalDateTime.now()); // It is defined at LocalDateTimeNow.

        if (updatedProductDTO.getDeliveryNoteID() != null) {
            existingProduct.setDeliveryNoteID(updatedProductDTO.getDeliveryNoteID());
        }
        if (updatedProductDTO.getPlaceOfStorage() != null) {
            existingProduct.setPlaceOfStorage(updatedProductDTO.getPlaceOfStorage());
        }
        if (updatedProductDTO.getDeliveryNoteID() != null) {
            existingProduct.setRoomPlanCode(updatedProductDTO.getRoomPlanCode());
        }
        if (updatedProductDTO.getDeliveryType() != null) {
            existingProduct.setDeliveryType(updatedProductDTO.getDeliveryType());
        }
        if (updatedProductDTO.getRoomNameOfInstallation() != null) {
            existingProduct.setRoomNameOfInstallation(updatedProductDTO.getRoomNameOfInstallation());
        }
        if (updatedProductDTO.getTimeOfInstalled() != null) {
            existingProduct.setTimeOfInstalled(updatedProductDTO.getTimeOfInstalled());
        }
        if (updatedProductDTO.getTimeOfArrivedAtSite() != null) {
            existingProduct.setTimeOfArrivedAtSite(updatedProductDTO.getTimeOfArrivedAtSite());
        }
        if (updatedProductDTO.getTimeOfOrder() != null) {
            existingProduct.setTimeOfOrder(updatedProductDTO.getTimeOfOrder());
        }
        // TODO: replace static conditions with EntityMapper

        // Save the updated entity
        return productRepository.save(existingProduct);
    }

}
