package com.bruteforce.secondroundassign_shiva.weblayer;

import com.bruteforce.secondroundassign_shiva.dto.ProductDto;
import com.bruteforce.secondroundassign_shiva.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService service;

    @Autowired
    public ProductController(ProductService service){
        this.service = service;
    }


    @PostMapping("/create-p")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDtoReq){
        ProductDto respDto = service.saveProduct(productDtoReq);
        return  new ResponseEntity<>(respDto, HttpStatus.CREATED);
    }

    @PostMapping("/create-products")
    public ResponseEntity<List<ProductDto>> createBatchProducts(@RequestBody List<ProductDto> list){
        List<ProductDto> response = service.saveProducts(list);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
}
