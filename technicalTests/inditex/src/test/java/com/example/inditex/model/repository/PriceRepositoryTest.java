package com.example.inditex.model.repository;

import com.example.inditex.model.PriceEntity;
import com.example.inditex.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PriceRepositoryTest {

    private final String testDate1 = "2020-06-14 01:00:00";
    private final Integer correctBrandId = 1;
    private final Integer incorrectBrandId = 2;
    private final Integer correctProductId = 35455;
    private final Integer incorrectProductId = 35456;

    @Autowired
    private PricesRepository pricesRepository;

    @Test
    public void testInvalidSearch() {
        List<PriceEntity> prices =
                pricesRepository.findApplicablyPrices(incorrectBrandId, incorrectProductId, null);
        assert(prices.isEmpty());
    }

    @Test
    public void testValidSearch() throws ParseException {
        Date dateFilter = (new SimpleDateFormat(Constants.DATE_FORMAT)).parse(testDate1);
        List<PriceEntity> prices =
                pricesRepository.findApplicablyPrices(correctBrandId, correctProductId,
                        dateFilter);
        assert(!prices.isEmpty() && prices.size() == 1);
        PriceEntity price = prices.get(0);
        assert(price.getBrandId().equals(correctBrandId)
                && price.getProductId().equals(correctProductId)
                && (price.getStartDate().before(dateFilter) && price.getEndDate().after(dateFilter)));
    }
}
