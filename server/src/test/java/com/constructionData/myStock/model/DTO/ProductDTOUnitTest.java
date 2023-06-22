package com.constructionData.myStock.model.DTO;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ProductDTOUnitTest {
    @Test

    public void builder_9ParametersAreAdded_theParametersAreEquals() {
        // Create an instance of ProductDTO using the builder pattern
        String relatedUnit = "VII.001";
        String category = "parketta";
        String productName = "tölgy juhar";
        Double quantity = 2.0;
        String quantityType = "nm";
        String productTechCode = "053900699";
        String roomNameOfInstallation = "nappali";
        String deliveryType = "generalDelivery";
        String roomPlanCode = "N-05";

        //Additional setters:
        LocalDateTime timeOfOrder = LocalDateTime.now();
        String deliveryNoteId = "deliveryNote-ID";
        LocalDateTime timeOfArrivedAtSite = LocalDateTime.now();
        String placeOfStorage = "pince-05";
        LocalDateTime timeOfInstalled = LocalDateTime.now();

        ProductDTO productDTO = ProductDTO.builder()
                .relatedUnit(relatedUnit)
                .category(category)
                .productName(productName)
                .quantity(quantity)
                .quantityType(quantityType)
                .productTechCode(productTechCode)
                .roomNameOfInstallation(roomNameOfInstallation)
                .deliveryType(deliveryType)
                .roomPlanCode(roomPlanCode)
                .timeOfOrder(timeOfOrder)
                .deliveryNoteID(deliveryNoteId)
                .timeOfArrivedAtSite(timeOfArrivedAtSite)
                .placeOfStorage(placeOfStorage)
                .timeOfInstalled(timeOfInstalled)
                .build();

        // Verify the values using getters or direct field access
        assertEquals(relatedUnit, productDTO.getRelatedUnit());
        assertEquals(category, productDTO.getCategory());
        assertEquals(productName, productDTO.getProductName());
        assertEquals(quantity, productDTO.getQuantity());
        assertEquals(quantityType, productDTO.getQuantityType());
        assertEquals(productTechCode, productDTO.getProductTechCode());
        assertEquals(roomNameOfInstallation, productDTO.getRoomNameOfInstallation());
        assertEquals(deliveryType, productDTO.getDeliveryType());
        assertEquals(roomPlanCode, productDTO.getRoomPlanCode());

        // Additional verify the values using getters:
        assertEquals(timeOfOrder, productDTO.getTimeOfOrder());
        assertEquals(deliveryNoteId, productDTO.getDeliveryNoteID());
        assertEquals(timeOfArrivedAtSite, productDTO.getTimeOfArrivedAtSite());
        assertEquals(placeOfStorage, productDTO.getPlaceOfStorage());
        assertEquals(timeOfInstalled, productDTO.getTimeOfInstalled());
    }

    @Test
    public void setterMethods_fourParameterAreSettled_shouldBeEquals() {
        // Create an instance of ProductDTO
        ProductDTO productDTO = ProductDTO.builder().build();

        // Set values using the setter methods
        String relatedUnit = "VII.001";
        productDTO.setRelatedUnit(relatedUnit);

        String category = "parketta";
        productDTO.setCategory(category);

        String productName = "tölgy juhar";
        productDTO.setProductName(productName);

        Double quantity = 2.0;
        productDTO.setQuantity(quantity);

        // Verify that the values were set correctly
        assertEquals(relatedUnit, productDTO.getRelatedUnit());
        assertEquals(category, productDTO.getCategory());
        assertEquals(productName, productDTO.getProductName());
        assertEquals(quantity, productDTO.getQuantity());
    }
}