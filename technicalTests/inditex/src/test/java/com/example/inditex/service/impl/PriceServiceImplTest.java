package com.example.inditex.service.impl;

import com.example.inditex.dto.PriceRequest;
import com.example.inditex.exception.ResourceNotFoundException;
import com.example.inditex.service.PriceService;
import com.example.inditex.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PriceServiceImplTest {

    private final String testDate1 = "2020-06-14 01:00:00";
    private final String testDate2 = "2020-06-13 01:00:00";
    private final Integer correctBrandId = 1;
    private final Integer incorrectBrandId = 2;
    private final Integer correctProductId = 35455;
    private final Integer incorrectProductId = 35456;

    @Autowired
    private PricesServiceImpl pricesService;

    @Test
    public void testOk() throws ParseException {
        Date dateFilter = (new SimpleDateFormat(Constants.DATE_FORMAT)).parse(testDate1);
        PriceRequest priceRequest = PriceRequest.builder().brandId(correctBrandId).productId(correctProductId).applicationDate(dateFilter).build();
        assert(pricesService.getApplyingPrice(priceRequest) != null);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testKoIncorrectBrand() throws ParseException {
        Date dateFilter = (new SimpleDateFormat(Constants.DATE_FORMAT)).parse(testDate1);
        PriceRequest priceRequest = PriceRequest.builder().brandId(incorrectBrandId).productId(correctProductId).applicationDate(dateFilter).build();
        pricesService.getApplyingPrice(priceRequest);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testKoIncorrectProduct() throws ParseException {
        Date dateFilter = (new SimpleDateFormat(Constants.DATE_FORMAT)).parse(testDate1);
        PriceRequest priceRequest = PriceRequest.builder().brandId(correctBrandId).productId(incorrectProductId).applicationDate(dateFilter).build();
        pricesService.getApplyingPrice(priceRequest);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testKoIncorrectDate() throws ParseException {
        Date dateFilter = (new SimpleDateFormat(Constants.DATE_FORMAT)).parse(testDate2);
        PriceRequest priceRequest = PriceRequest.builder().brandId(correctBrandId).productId(correctProductId).applicationDate(dateFilter).build();
        pricesService.getApplyingPrice(priceRequest);
    }
}
