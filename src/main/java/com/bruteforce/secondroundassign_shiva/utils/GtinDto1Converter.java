package com.bruteforce.secondroundassign_shiva.utils;

import com.bruteforce.secondroundassign_shiva.dto.ProductDto;
import com.bruteforce.secondroundassign_shiva.dto.RequestGtinDto1;
import com.bruteforce.secondroundassign_shiva.dto.ResponseGtinDto1;
import com.bruteforce.secondroundassign_shiva.model.Gtin;
import com.bruteforce.secondroundassign_shiva.model.Product;

public class GtinDto1Converter {

    public static ResponseGtinDto1 convertToDto(Gtin gtin) {

        ResponseGtinDto1 dto = new ResponseGtinDto1();
        dto.setGtinId(gtin.getGtinId());
        dto.setGtinName(gtin.getGtinName());

        // Extract data from the product to convert into ProductDto
        ProductDto prodDto = new ProductDto(
                gtin.getProduct().getProductId(), // ProductId
                gtin.getProduct().getProductName(), // ProductName
                gtin.getProduct().getCreatedOn() // createdOn (Date)
        );

        dto.setProduct(prodDto);
        return dto;
    }

    public static Gtin convertToEntity(RequestGtinDto1 dto, Product prod) {
        Gtin entity = new Gtin();
        entity.setGtinName(dto.getGtinName());
        entity.setProduct(prod);
        return entity;
    }

}
