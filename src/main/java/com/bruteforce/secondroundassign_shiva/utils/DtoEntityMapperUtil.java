package com.bruteforce.secondroundassign_shiva.utils;

import com.bruteforce.secondroundassign_shiva.dto.BatchDto;
import com.bruteforce.secondroundassign_shiva.dto.GtinDto;
import com.bruteforce.secondroundassign_shiva.dto.ProductDto;
import com.bruteforce.secondroundassign_shiva.model.Batch;
import com.bruteforce.secondroundassign_shiva.model.Gtin;
import com.bruteforce.secondroundassign_shiva.model.Product;
import org.springframework.beans.BeanUtils;

public class DtoEntityMapperUtil {

    // product conversion
    public static Product toEntity(ProductDto dto) {
        Product entity = new Product();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    public static ProductDto toDto(Product entity) {
        ProductDto dto = new ProductDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    // Gtin Conversion
    public static Gtin toEntity(GtinDto dto, Product prod) {
        Gtin entity = new Gtin();
        BeanUtils.copyProperties(dto, entity);
        entity.setProduct(prod);
        return entity;
    }

    public static GtinDto toDto(Gtin entity) {
        GtinDto dto = new GtinDto();
        BeanUtils.copyProperties(entity, dto);
        if (entity.getProduct() != null) {
            dto.setProduct(toDto(entity.getProduct()));
        }
        return dto;
    }

    // Batch Conversion

    public static Batch toEntity(BatchDto dto, Gtin gtin) {
        Batch entity = new Batch();
        BeanUtils.copyProperties(dto, entity);
        entity.setGtin(gtin);
        return entity;
    }

    public static BatchDto toDto(Batch entity) {
        BatchDto dto = new BatchDto();
        BeanUtils.copyProperties(entity, dto);
        if (entity.getGtin() != null) {
            dto.setGtinId(entity.getGtin().getGtinId());
        }
        return dto;
    }
}
