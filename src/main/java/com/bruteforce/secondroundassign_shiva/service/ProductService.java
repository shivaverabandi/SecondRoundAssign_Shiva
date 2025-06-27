package com.bruteforce.secondroundassign_shiva.service;

import com.bruteforce.secondroundassign_shiva.dto.ProductDto;
import com.bruteforce.secondroundassign_shiva.model.Product;
import com.bruteforce.secondroundassign_shiva.repo.IProductRepo;
import com.bruteforce.secondroundassign_shiva.utils.ProductDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private IProductRepo repo;

    @Autowired
    public ProductService(IProductRepo repo){
        this.repo = repo;
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product new_p = ProductDtoConverter.convertToEntity(productDto);
        new_p = repo.save(new_p);
        ProductDto responseDto = ProductDtoConverter.convertToDto(new_p);
        return responseDto;
    }

    public List<ProductDto> saveProducts(List<ProductDto> list){
        List<Product> listEntity = list.stream()
                        .map(pDto -> ProductDtoConverter.convertToEntity(pDto))
                .toList();
        List<ProductDto> response = repo.saveAll(listEntity).stream()
                .map(pEntity -> ProductDtoConverter.convertToDto(pEntity))
                .toList();
        return  response;
    }

}
