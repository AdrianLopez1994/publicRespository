package com.example.inditex.controller;

import com.example.inditex.dto.PriceResponse;
import com.example.inditex.exception.ResourceNotFoundException;
import com.example.inditex.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PricesControllerTest {

    private final String testDate1 = "2020-06-14 01:00:00";
    private final String testDate2 = "2020-06-14 16:00:00";
    private final String testDate3 = "2020-06-14 21:00:00";
    private final String testDate4 = "2020-06-15 10:00:00";
    private final String testDate5 = "2020-06-16 21:00:00";
    private final Integer correctBrandId = 1;
    private final Integer incorrectBrandId = 2;
    private final Integer correctProductId = 35455;
    private final Integer incorrectProductId = 35456;
    private final BigDecimal priceProductTestOk1 = new BigDecimal(35.50);
    private final BigDecimal priceProductTestOk2 = new BigDecimal(25.45);
    private final BigDecimal priceProductTestOk3 = new BigDecimal(35.50);
    private final BigDecimal priceProductTestOk4 = new BigDecimal(30.50);
    private final BigDecimal priceProductTestOk5 = new BigDecimal(38.95);

    @Autowired
    private PricesController pricesController;

    @Test
    public void testOk1() throws ParseException {
        Date dateFilter = (new SimpleDateFormat(Constants.DATE_FORMAT)).parse(testDate1);
        ResponseEntity<PriceResponse> response = pricesController.getProductPrice(correctBrandId, correctProductId, dateFilter);

        assert(response.getStatusCode().equals(HttpStatus.OK));
        assert(response.getBody().getProduct().equals(correctProductId));
        assert(response.getBody().getBrand().equals(correctBrandId));
        assert(response.getBody().getPrice().doubleValue() == priceProductTestOk1.doubleValue());
    }

    @Test
    public void testOk2() throws ParseException {
        Date dateFilter = (new SimpleDateFormat(Constants.DATE_FORMAT)).parse(testDate2);
        ResponseEntity<PriceResponse> response = pricesController.getProductPrice(correctBrandId, correctProductId, dateFilter);

        assert(response.getStatusCode().equals(HttpStatus.OK));
        assert(response.getBody().getProduct().equals(correctProductId));
        assert(response.getBody().getBrand().equals(correctBrandId));
        assert(response.getBody().getPrice().doubleValue() == priceProductTestOk2.doubleValue());
    }

    @Test
    public void testOk3() throws ParseException {
        Date dateFilter = (new SimpleDateFormat(Constants.DATE_FORMAT)).parse(testDate3);
        ResponseEntity<PriceResponse> response = pricesController.getProductPrice(correctBrandId, correctProductId, dateFilter);

        assert(response.getStatusCode().equals(HttpStatus.OK));
        assert(response.getBody().getProduct().equals(correctProductId));
        assert(response.getBody().getBrand().equals(correctBrandId));
        assert(response.getBody().getPrice().doubleValue() == priceProductTestOk3.doubleValue());
    }

    @Test
    public void testOk4() throws ParseException {
        Date dateFilter = (new SimpleDateFormat(Constants.DATE_FORMAT)).parse(testDate4);
        ResponseEntity<PriceResponse> response = pricesController.getProductPrice(correctBrandId, correctProductId, dateFilter);

        assert(response.getStatusCode().equals(HttpStatus.OK));
        assert(response.getBody().getProduct().equals(correctProductId));
        assert(response.getBody().getBrand().equals(correctBrandId));
        assert(response.getBody().getPrice().doubleValue() == priceProductTestOk4.doubleValue());
    }

    @Test
    public void testOk5() throws ParseException {
        Date dateFilter = (new SimpleDateFormat(Constants.DATE_FORMAT)).parse(testDate5);
        ResponseEntity<PriceResponse> response = pricesController.getProductPrice(correctBrandId, correctProductId, dateFilter);

        assert(response.getStatusCode().equals(HttpStatus.OK));
        assert(response.getBody().getProduct().equals(correctProductId));
        assert(response.getBody().getBrand().equals(correctBrandId));
        assert(response.getBody().getPrice().doubleValue() == priceProductTestOk5.doubleValue());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testKoNotFoundIncorrectBrandId() throws ParseException {
        Date dateFilter = (new SimpleDateFormat(Constants.DATE_FORMAT)).parse(testDate5);
        pricesController.getProductPrice(incorrectBrandId, correctProductId, dateFilter);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testKoNotFoundIncorrectProductId() throws ParseException {
        Date dateFilter = (new SimpleDateFormat(Constants.DATE_FORMAT)).parse(testDate5);
        pricesController.getProductPrice(correctBrandId, incorrectProductId, dateFilter);
    }
}
