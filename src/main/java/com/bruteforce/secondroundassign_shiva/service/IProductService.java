package com.bruteforce.secondroundassign_shiva.service;

import com.bruteforce.secondroundassign_shiva.Exceptions.ProductAlreadyExists;
import com.bruteforce.secondroundassign_shiva.dto.ProductDto;

public interface IProductService {

    ProductDto saveProduct(ProductDto productDto) throws ProductAlreadyExists;

}
