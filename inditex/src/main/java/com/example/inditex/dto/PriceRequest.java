package com.example.inditex.dto;

import lombok.*;

import java.util.Date;

@Builder(builderClassName = "Builder", toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceRequest {
    private Integer productId;
    private Integer brandId;
    private Date applicationDate;
}
