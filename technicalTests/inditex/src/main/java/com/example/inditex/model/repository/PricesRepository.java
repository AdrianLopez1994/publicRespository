package com.example.inditex.model.repository;

import com.example.inditex.model.PriceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PricesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<PriceEntity> findApplicablyPrices(Integer brandId, Integer productId, Date applicationDate) {
        Query query =  entityManager.createQuery(
                "SELECT p " +
                        "FROM PriceEntity p " +
                         "WHERE p.brandId = :brandId " +
                             "AND p.productId = :productId " +
                             "AND :applicationDate > p.startDate " +
                             "AND :applicationDate < p.endDate ORDER BY p.priority DESC");
        query.setParameter("brandId", brandId);
        query.setParameter("productId", productId);
        query.setParameter("applicationDate", applicationDate);

        query.setMaxResults(1);

        return query.getResultList();
    }
}
