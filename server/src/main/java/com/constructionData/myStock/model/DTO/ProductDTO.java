package com.constructionData.myStock.model.DTO;

import jakarta.persistence.Id;
import lombok.Builder;

import java.time.LocalDateTime;

public record ProductDTO(

        // TODO: test DTO parameters

        //Office-Define
        String relatedUnit, // VII.001
        String category, // parketta
        String productName, // tölgy juhar
        Double quantity, // 2
        String quantityType, // nm;
        String productTechCode, // 053900699
        String deliveryType, // generalDelivery
        String roomNameOfInstallation, // nappali
        String roomPlanCode, //optional // N-05
        LocalDateTime timeOfRecord, // dateAndTime

        //Office-ordered
        LocalDateTime timeOfOrder, // dateAndTime

        //Site-handover
        String deliveryNoteID, //optional; // 1568
        LocalDateTime timeOfArrivedAtSite, // dateAndTime
        String placeOfStorage, // P1 raktar

        //Site-installed
        LocalDateTime timeOfInstalled, // dateAndTime

        //Server
        LocalDateTime lastTimeOfModified // dateAndTime
) {

    @Builder
    public ProductDTO {
    }
}
