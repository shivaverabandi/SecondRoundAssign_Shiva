package com.bruteforce.secondroundassign_shiva.utils;

import com.bruteforce.secondroundassign_shiva.dto.ResponseGtinDto2;
import com.bruteforce.secondroundassign_shiva.model.Gtin;

public class GtinDto2Converter {

    public static ResponseGtinDto2 convertToDto2(Gtin gtin){
        ResponseGtinDto2 response = new ResponseGtinDto2();
        response.setGtinId(gtin.getGtinId());
        response.setGtinName(gtin.getGtinName());
        response.setProduct(ProductDtoConverter.convertToDto(gtin.getProduct()));
        return response;
    }
}
