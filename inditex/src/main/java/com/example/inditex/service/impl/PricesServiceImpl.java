package com.example.inditex.service.impl;

import com.example.inditex.dto.PriceRequest;
import com.example.inditex.exception.ResourceNotFoundException;
import com.example.inditex.model.PriceEntity;
import com.example.inditex.model.repository.PricesRepository;
import com.example.inditex.model.repository.PricesRepositoryOld;
import com.example.inditex.service.PriceService;
import com.example.inditex.utils.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PricesServiceImpl implements PriceService {

    private PricesRepository pricesRepository;

    public PriceEntity getApplyingPrice(PriceRequest request) {

        List<PriceEntity> result = pricesRepository.findApplicablyPrices(request.getBrandId(),
                                                    request.getProductId(),
                                                    request.getApplicationDate());
        if(result == null || result.isEmpty())
            throw new ResourceNotFoundException(ExceptionEnum.RESOURCE_NOT_FOUND.getMessage());

        //The results are ordered so, the first one has the correct price
        return result.get(0);
    }
}
