package com.example.inditex.model.repository;

import com.example.inditex.model.PriceEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PricesRepositoryOld extends CrudRepository<PriceEntity, Integer> {

    @Query("SELECT p " +
            "FROM PriceEntity p " +
            "WHERE p.brandId = :brandId " +
                "AND p.productId = :productId " +
                "AND :applicationDate > p.startDate " +
                "AND :applicationDate < p.endDate ORDER BY p.priority DESC")
    List<PriceEntity> findAllApplicablyPrices(Integer brandId, Integer productId, Date applicationDate);
}
