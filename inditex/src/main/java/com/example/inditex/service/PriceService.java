package com.example.inditex.service;

import com.example.inditex.dto.PriceRequest;
import com.example.inditex.model.PriceEntity;

public interface PriceService {

    PriceEntity getApplyingPrice(PriceRequest request);

}
