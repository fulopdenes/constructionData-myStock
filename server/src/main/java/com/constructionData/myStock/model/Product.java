package com.constructionData.myStock.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "products")
public class Product {

    //Office-Define
    @Id
    @Basic(optional = false)
    @Column(updatable = false, nullable = false)
    @SequenceGenerator(name = "product_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String relatedUnit; // VII.001
    private String category; // parketta
    private String productName; // tölgy juhar
    private Double quantity; // 2
    private String quantityType; // nm;
    private String productTechCode; // 053900699
    private String deliveryType; // generalDelivery
    private String roomNameOfInstallation; // nappali
    private String roomPlanCode; //optional // N-05
    private LocalDateTime timeOfRecord; // dateAndTime

    //Office-ordered
    private LocalDateTime timeOfOrder; // dateAndTime

    //Site-handover
    private String deliveryNoteID; //optional; // 1568
    private LocalDateTime timeOfArrivedAtSite; // dateAndTime
    private String placeOfStorage; // P1 raktar

    //Site-installed
    private LocalDateTime timeOfInstalled; // dateAndTime

    //Server
    private LocalDateTime lastTimeOfModified; // dateAndTime
}
