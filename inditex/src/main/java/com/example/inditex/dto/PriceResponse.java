package com.example.inditex.dto;

import com.example.inditex.utils.enums.CurrencyEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceResponse {

    private Integer product;

    private Integer priceList;

    private Integer brand;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;
}
