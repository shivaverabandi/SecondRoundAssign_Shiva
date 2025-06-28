package com.bruteforce.secondroundassign_shiva.weblayer;

import com.bruteforce.secondroundassign_shiva.dto.RequestGtinDto1;
import com.bruteforce.secondroundassign_shiva.dto.ResponseGtinDto1;
import com.bruteforce.secondroundassign_shiva.dto.ResponseGtinDto2;
import com.bruteforce.secondroundassign_shiva.service.IGtinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gtin")
public class GtinController {

    /**
     * An instance of the IGtinService interface that provides business logic
     * for operations related to GTIN (Global Trade Item Number) management.
     * This variable is used to delegate the processing of GTIN requests,
     * such as creating GTINs and retrieving GTIN-related information.
     */
    private IGtinService service;

    /**
     * Constructs a new GtinController with the specified IGtinService.
     *
     * @param service the IGtinService instance used to perform operations related to GTIN data
     */
    @Autowired
    public GtinController(IGtinService service){
        this.service = service;
    }
    /**
     * Creates a new GTIN (Global Trade Item Number) entry in the system with the provided details.
     *
     * @param reqDto the request data transfer object containing GTIN name and associated product ID
     * @return a {@link ResponseEntity} containing the response data transfer object with the details
     *         of the newly created GTIN and a status of {@link HttpStatus#CREATED}
     */
    @PostMapping("/create-gtin")
    public ResponseEntity<ResponseGtinDto1> createGtin(@RequestBody RequestGtinDto1 reqDto){
        return new ResponseEntity<>(service.createGtin(reqDto), HttpStatus.CREATED);
    }

    /**
     * Creates multiple GTINs (Global Trade Item Numbers) from the provided list of request DTOs.
     *
     * @param list a list of {@link RequestGtinDto1} objects, each containing details for creating a GTIN
     * @return a {@link ResponseEntity} containing a list of {@link ResponseGtinDto1} objects representing the
     *         created GTINs, along with the HTTP status code of 201 (Created)
     */
    @PostMapping("/create-gtins")
    public ResponseEntity<List<ResponseGtinDto1>> createGtins(@RequestBody List<RequestGtinDto1> list){
        return new ResponseEntity<>(service.createGtins(list), HttpStatus.CREATED);
    }

    /**
     * Retrieves all GTINs (Global Trade Item Numbers) from the database.
     *
     * @return a {@code ResponseEntity} containing a list of {@code ResponseGtinDto2}.
     *         If no GTINs are available, returns an empty list with HTTP status {@code NO_CONTENT}.
     *         Otherwise, returns the list with HTTP status {@code OK}.
     */
    @GetMapping("/get-all-gtins")
    public ResponseEntity<List<ResponseGtinDto2>> getAllGtins(){
        List<ResponseGtinDto2> list = service.getAllGtins();
        if(list.isEmpty())
            return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    /**
     * Retrieves all GTINs (Global Trade Item Numbers) that have a batch with a positive available quantity.
     *
     * @return a {@link ResponseEntity} containing a list of GTINs if found.
     *         Returns a {@code ResponseEntity} with an empty list and HTTP status {@code NO_CONTENT}
     *         if no such GTINs are available. Otherwise, responds with HTTP status {@code OK}.
     */
    @GetMapping("/get-allGtins-with-pos-quant-inBatch")
    public ResponseEntity<List<String>> getAllGtinsWithBatchAvailableQuantityPositive(){
        List<String> response = service.findAllGtinsContainingBatchAvailableQuantityPositive();
        if(response.isEmpty())
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
