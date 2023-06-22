package com.constructionData.myStock.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ProductUnitTest {

    @Test
    public void testProductConstructorAndGetters() {
        // Create a product with test data
        Long id = 1L;
        String relatedUnit = "VII.001";
        String category = "parketta";
        String productName = "tölgy juhar";
        Double quantity = 2.0;
        String quantityType = "nm";
        String productTechCode = "053900699";
        String roomNameOfInstallation = "nappali";
        String deliveryType = "generalDelivery";
        String roomPlanCode = "N-05";
        LocalDateTime timeOfRecord = LocalDateTime.now();

        Product product = new Product(id, relatedUnit, category, productName, quantity, quantityType, productTechCode,
                roomNameOfInstallation, deliveryType, roomPlanCode, timeOfRecord);

        // Verify the values using getters
        assertEquals(id, product.getId());
        assertEquals(relatedUnit, product.getRelatedUnit());
        assertEquals(category, product.getCategory());
        assertEquals(productName, product.getProductName());
        assertEquals(quantity, product.getQuantity());
        assertEquals(quantityType, product.getQuantityType());
        assertEquals(productTechCode, product.getProductTechCode());
        assertEquals(roomNameOfInstallation, product.getRoomNameOfInstallation());
        assertEquals(deliveryType, product.getDeliveryType());
        assertEquals(roomPlanCode, product.getRoomPlanCode());
        assertEquals(timeOfRecord, product.getTimeOfRecord());
    }

    @Test
    public void testProductSetters() {
        // Create a product with default constructor
        Product product = new Product();

        // Set test values using setters
        Long id = 1L;
        String relatedUnit = "VII.001";
        String category = "parketta";
        String productName = "tölgy juhar";
        Double quantity = 2.0;
        String quantityType = "nm";
        String productTechCode = "053900699";
        String roomNameOfInstallation = "nappali";
        String deliveryType = "generalDelivery";
        String roomPlanCode = "N-05";
        LocalDateTime timeOfRecord = LocalDateTime.now();

            //Additional setters:
        LocalDateTime timeOfOrder = LocalDateTime.now();
        String deliveryNoteId = "deliveryNote-ID";
        LocalDateTime timeOfArrivedAtSite = LocalDateTime.now();
        String placeOfStorage = "pince-05";
        LocalDateTime timeOfInstalled = LocalDateTime.now();
        LocalDateTime lastTimeOfModified = LocalDateTime.now();

        //Default setters:
        product.setId(id);
        product.setRelatedUnit(relatedUnit);
        product.setCategory(category);
        product.setProductName(productName);
        product.setQuantity(quantity);
        product.setQuantityType(quantityType);
        product.setProductTechCode(productTechCode);
        product.setRoomNameOfInstallation(roomNameOfInstallation);
        product.setDeliveryType(deliveryType);
        product.setRoomPlanCode(roomPlanCode);
        product.setTimeOfRecord(timeOfRecord);

            // Additional setters:
        product.setTimeOfOrder(timeOfOrder);
        product.setDeliveryNoteID(deliveryNoteId);
        product.setTimeOfArrivedAtSite(timeOfArrivedAtSite);
        product.setPlaceOfStorage(placeOfStorage);
        product.setTimeOfInstalled(timeOfInstalled);
        product.setLastTimeOfModified(lastTimeOfModified);

        // Verify the values using getters
        assertEquals(id, product.getId());
        assertEquals(relatedUnit, product.getRelatedUnit());
        assertEquals(category, product.getCategory());
        assertEquals(productName, product.getProductName());
        assertEquals(quantity, product.getQuantity());
        assertEquals(quantityType, product.getQuantityType());
        assertEquals(productTechCode, product.getProductTechCode());
        assertEquals(roomNameOfInstallation, product.getRoomNameOfInstallation());
        assertEquals(deliveryType, product.getDeliveryType());
        assertEquals(roomPlanCode, product.getRoomPlanCode());
        assertEquals(timeOfRecord, product.getTimeOfRecord());

            // Additional verify the values using getters:
        assertEquals(timeOfOrder, product.getTimeOfOrder());
        assertEquals(deliveryNoteId, product.getDeliveryNoteID());
        assertEquals(timeOfArrivedAtSite, product.getTimeOfArrivedAtSite());
        assertEquals(placeOfStorage, product.getPlaceOfStorage());
        assertEquals(timeOfInstalled, product.getTimeOfInstalled());
        assertEquals(lastTimeOfModified, product.getLastTimeOfModified());
    }

    // Add additional unit tests as needed for other methods or behaviors of the Product class

    @Test
    public void testBuilder() {
        // Create an instance of Product using the builder pattern
        Long id = 1L;
        String relatedUnit = "VII.001";
        String category = "parketta";
        String productName = "tölgy juhar";
        Double quantity = 2.0;

        Product product = Product.builder()
                .id(id)
                .relatedUnit(relatedUnit)
                .category(category)
                .productName(productName)
                .quantity(quantity)
                .build();

        // Verify the values using getters or direct field access
        assertEquals(id, product.getId());
        assertEquals(relatedUnit, product.getRelatedUnit());
        assertEquals(category, product.getCategory());
        assertEquals(productName, product.getProductName());
        assertEquals(quantity, product.getQuantity());
    }

    @Test
    public void testAllArgsConstructor() {
        // Create an instance of Product using all arguments constructor
        Long id = 1L;
        String relatedUnit = "VII.001";
        String category = "parketta";
        String productName = "tölgy juhar";
        Double quantity = 2.0;
        String quantityType = "nm";
        String productTechCode = "053900699";
        String roomNameOfInstallation = "nappali";

        Product product = Product.builder()
                .id(id)
                .relatedUnit(relatedUnit)
                .category(category)
                .productName(productName)
                .quantity(quantity)
                .quantityType(quantityType)
                .productTechCode(productTechCode)
                .roomNameOfInstallation(roomNameOfInstallation)
                .build();

        // Verify the values using getters or direct field access
        assertEquals(id, product.getId());
        assertEquals(relatedUnit, product.getRelatedUnit());
        assertEquals(category, product.getCategory());
        assertEquals(productName, product.getProductName());
        assertEquals(quantity, product.getQuantity());
        assertEquals(quantityType, product.getQuantityType());
        assertEquals(productTechCode, product.getProductTechCode());
        assertEquals(roomNameOfInstallation, product.getRoomNameOfInstallation());
    }
}