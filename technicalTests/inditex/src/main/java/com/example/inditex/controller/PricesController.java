package com.example.inditex.controller;

import com.example.inditex.dto.PriceRequest;
import com.example.inditex.dto.PriceResponse;
import com.example.inditex.mapper.PriceResponseMapper;
import com.example.inditex.model.PriceEntity;
import com.example.inditex.service.impl.PricesServiceImpl;
import com.example.inditex.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@AllArgsConstructor
@Slf4j
public class PricesController {

    private PricesServiceImpl pricesServiceImpl;
    private PriceResponseMapper priceResponseMapper;

    @GetMapping("/prices")
    @ResponseBody
    public ResponseEntity<PriceResponse> getProductPrice(@RequestParam Integer brandId,
                                                         @RequestParam Integer productId,
                                     @RequestParam @DateTimeFormat(pattern = Constants.DATE_FORMAT) Date applicationDate) {
        PriceRequest priceRequest = PriceRequest.builder().brandId(brandId)
                                                          .productId(productId)
                                                          .applicationDate(applicationDate).build();
        PriceEntity priceEntity = pricesServiceImpl.getApplyingPrice(priceRequest);
        PriceResponse response = priceResponseMapper.convertToResponseDtoType(priceEntity);

        return ResponseEntity.ok(response);
    }
}
