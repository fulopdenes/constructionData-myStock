package com.constructionData.myStock.model.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDateTime;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "products")
public class ProductDTO {

    // Office-Define
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String buildingId;

    @NotNull
    @Column(nullable = false)
    private String relatedUnit;

    @NotBlank
    @Column(nullable = false)
    private String categoryType;

    @NotBlank
    @Column(nullable = false)
    private String productName;

    @Positive
    @Column(nullable = false)
    private double quantity;

    @NotBlank
    @Column(nullable = false)
    private String quantityType;

    @NotBlank
    @Column(nullable = false)
    private String productTechCode;

    @NotBlank
    @Column(nullable = false)
    private String roomNameOfInstallation;

    private String deliveryType;

    private String roomPlanCode;

    // Office-ordered
    private LocalDateTime timeOfOrder;

    // Site-handover
    private String deliveryNoteId;

    private LocalDateTime timeOfArrivedAtSite;

    private String placeOfStorage;

    // Site-installed
    private LocalDateTime timeOfInstalled;

    // Server
    private LocalDateTime timeOfRecord;

    private LocalDateTime lastTimeOfModified;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", buildingId='" + buildingId + '\'' +
                ", relatedUnit=" + relatedUnit +
                ", categoryType='" + categoryType + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", quantityType='" + quantityType + '\'' +
                ", productTechCode='" + productTechCode + '\'' +
                ", roomNameOfInstallation='" + roomNameOfInstallation + '\'' +
                ", deliveryType='" + deliveryType + '\'' +
                ", roomPlanCode='" + roomPlanCode + '\'' +
                ", timeOfOrder=" + timeOfOrder +
                ", deliveryNoteId='" + deliveryNoteId + '\'' +
                ", timeOfArrivedAtSite=" + timeOfArrivedAtSite +
                ", placeOfStorage='" + placeOfStorage + '\'' +
                ", timeOfInstalled=" + timeOfInstalled +
                ", timeOfRecord=" + timeOfRecord +
                ", lastTimeOfModified=" + lastTimeOfModified +
                '}';
    }
}

