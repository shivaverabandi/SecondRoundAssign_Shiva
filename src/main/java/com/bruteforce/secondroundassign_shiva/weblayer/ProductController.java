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

/**
 * This class serves as a REST controller for managing operations related to products.
 * It provides endpoints for creating individual products and batch-creating multiple products.
 * The controller delegates the business logic to an instance of {@link ProductService}.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService service;

    @Autowired
    public ProductController(ProductService service){
        this.service = service;
    }


    /**
     * Creates a new product based on the provided product details.
     *
     * @param productDtoReq the {@link ProductDto} containing the details of the product to be created
     * @return a {@link ResponseEntity} containing the created {@link ProductDto} object
     *         and an HTTP status code of {@link HttpStatus#CREATED}
     */
    @PostMapping("/create-p")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDtoReq){
        ProductDto respDto = service.saveProduct(productDtoReq);
        return  new ResponseEntity<>(respDto, HttpStatus.CREATED);
    }

    /**
     * Creates multiple products based on the provided list of product details.
     *
     * @param list the list of {@link ProductDto} objects containing details of the products to be created
     * @return a {@link ResponseEntity} containing a list of created {@link ProductDto} objects
     *         and an HTTP status code of {@link HttpStatus#CREATED}
     */
    @PostMapping("/create-products")
    public ResponseEntity<List<ProductDto>> createBatchProducts(@RequestBody List<ProductDto> list){
        List<ProductDto> response = service.saveProducts(list);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
}
