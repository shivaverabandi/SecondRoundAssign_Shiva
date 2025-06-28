package com.bruteforce.secondroundassign_shiva.weblayer;

import com.bruteforce.secondroundassign_shiva.dto.RequestBatchDto;
import com.bruteforce.secondroundassign_shiva.dto.ResponseBatchDto;
import com.bruteforce.secondroundassign_shiva.service.IBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class serves as a REST controller for managing batch-related operations.
 * It provides endpoints to create a batch and retrieve the latest non-positive batch
 * based on specific filters.
 */
@RestController
@RequestMapping("/batch")
public class BatchController {

    private IBatchService b_service;

    @Autowired
    public BatchController(IBatchService service){
        this.b_service = service;
    }
    /**
     * Creates a new batch with the provided details.
     *
     * @param reqDto the request data transfer object containing batch details
     *               including MRP, batch name, selling price, purchase price,
     *               available quantity, inwarded date, and associated GTIN ID
     * @return a {@link ResponseEntity} containing the response data transfer object
     *         with the details of the newly created batch and a status of {@link HttpStatus#CREATED}
     */
    @PostMapping("/create-b")
    public ResponseEntity<ResponseBatchDto> createBatch(@RequestBody RequestBatchDto reqDto){
        return new ResponseEntity<>(b_service.createBatch(reqDto), HttpStatus.CREATED);
    }

    /**
     * Retrieves the latest non-positive batch based on an inWarded filter.
     * This method uses the service layer to fetch data related to a batch
     * that meets specific conditions and returns it as a response.
     *
     * @return a {@link ResponseEntity} containing a {@link ResponseBatchDto} object.
     *         The response includes batch details such as batch ID, MRP, batch name,
     *         selling price (SP), purchase price, available quantity, inwarded date,
     *         and associated GTIN details. The HTTP response status is {@link HttpStatus#OK}.
     */
    @GetMapping("/get-latest-non-pos-batch")
    public ResponseEntity<ResponseBatchDto> getNonPositiveBatchBasedOnLatestInWardedFilter(){
        ResponseBatchDto response = b_service.getNonPositiveBatchBasedOnLatestInWardedFilter();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
