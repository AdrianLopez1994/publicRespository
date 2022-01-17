package com.example.inditex.model;

import com.example.inditex.utils.enums.CurrencyEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PRICES")
@Data
@Getter
@Setter
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "BRAND_ID")
    @JsonProperty("brand")
    private Integer brandId;

    @Column(name = "START_DATE")
    @JsonProperty("startDate")
    private Date startDate;

    @Column(name = "END_DATE")
    @JsonProperty("endDate")
    private Date endDate;

    @Column(name = "PRICE_LIST")
    @JsonProperty("priceList")
    private Integer priceList;

    @Column(name = "PRODUCT_ID")
    @JsonProperty("product")
    private Integer productId;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "PRICE")
    @JsonProperty("price")
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "CURR")
    @JsonProperty("currency")
    private CurrencyEnum currency;
}
