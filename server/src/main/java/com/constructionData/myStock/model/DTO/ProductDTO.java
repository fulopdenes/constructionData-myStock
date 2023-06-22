package com.constructionData.myStock.model.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
@Builder
public class ProductDTO {

    //Office-Define
    private String relatedUnit; // VII.001
    private String category; // parketta
    private String productName; // tölgy juhar
    private Double quantity; // 2
    private String quantityType; // nm;
    private String productTechCode; // 053900699
    private String deliveryType; // generalDelivery
    private String roomNameOfInstallation; // nappali
    private String roomPlanCode; //optional // N-05

    //Office-ordered
    private LocalDateTime timeOfOrder; // dateAndTime

    //Site-handover
    private String deliveryNoteID; //optional; // 1568
    private LocalDateTime timeOfArrivedAtSite; // dateAndTime
    private String placeOfStorage; // P1 raktar

    //Site-installed
    private LocalDateTime timeOfInstalled; // dateAndTime
}

