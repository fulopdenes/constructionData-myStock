package com.constructionData.myStock.repository;

import com.constructionData.myStock.model.DTO.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDTO, Long> {
}
