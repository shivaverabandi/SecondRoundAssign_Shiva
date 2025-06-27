package com.bruteforce.secondroundassign_shiva.service;

import com.bruteforce.secondroundassign_shiva.dto.ProductDto;
import com.bruteforce.secondroundassign_shiva.model.Product;
import com.bruteforce.secondroundassign_shiva.repo.IProductRepo;
import com.bruteforce.secondroundassign_shiva.utils.DtoEntityMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    private IProductRepo repo;

    @Autowired
    public ProductService(IProductRepo repo){
        this.repo = repo;
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product new_p = DtoEntityMapperUtil.toEntity(productDto);
        new_p = repo.save(new_p);
        ProductDto responseDto = DtoEntityMapperUtil.toDto(new_p);
        return responseDto;
    }



}
