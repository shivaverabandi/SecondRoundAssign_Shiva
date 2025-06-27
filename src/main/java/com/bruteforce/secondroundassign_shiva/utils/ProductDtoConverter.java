package com.bruteforce.secondroundassign_shiva.utils;

import com.bruteforce.secondroundassign_shiva.dto.ProductDto;
import com.bruteforce.secondroundassign_shiva.model.Product;
import org.springframework.beans.BeanUtils;

public class ProductDtoConverter {

    public static Product convertToEntity(ProductDto dto){
        Product entity = new Product();
        BeanUtils.copyProperties(dto,entity);
        return entity;
    }

    public static ProductDto convertToDto(Product entity){
        ProductDto dto = new ProductDto();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }
}
