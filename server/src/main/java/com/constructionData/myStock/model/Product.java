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
    @Column(nullable = false)
    private String relatedUnit; // VII.001
    @Column(nullable = false)
    private String category; // parketta
    @Column(nullable = false)
    private String productName; // tölgy juhar
    @Column(nullable = false)
    private Double quantity; // 2
    @Column(nullable = false)
    private String quantityType; // nm;
    @Column(nullable = false)
    private String productTechCode; // 053900699
    @Column(nullable = false)
    private String roomNameOfInstallation; // nappali

    private String deliveryType; // generalDelivery
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
