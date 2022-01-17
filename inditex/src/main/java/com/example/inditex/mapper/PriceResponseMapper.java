package com.example.inditex.mapper;

import com.example.inditex.dto.PriceResponse;
import com.example.inditex.model.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PriceResponseMapper {

    @Mappings ({
            @Mapping(target = "product", source = "productId"),
            @Mapping(target = "brand", source = "brandId")
    })
    PriceResponse convertToResponseDtoType(PriceEntity entity);
}
