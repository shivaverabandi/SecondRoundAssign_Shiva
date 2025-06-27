package com.bruteforce.secondroundassign_shiva.weblayer;

import com.bruteforce.secondroundassign_shiva.dto.RequestBatchDto;
import com.bruteforce.secondroundassign_shiva.dto.ResponseBatchDto;
import com.bruteforce.secondroundassign_shiva.service.IBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/batch")
public class BatchController {

    private IBatchService b_service;

    @Autowired
    public BatchController(IBatchService service){
        this.b_service = service;
    }
    @PostMapping("/create-b")
    public ResponseEntity<ResponseBatchDto> createBatch(@RequestBody RequestBatchDto reqDto){
        return new ResponseEntity<>(b_service.createBatch(reqDto), HttpStatus.CREATED);
    }

//    @GetMapping("/getlast-added-batch")
//    public ResponseEntity<BatchDto> findNonPosBatchByGtin(){
//        return new ResponseEntity<>(b_service.findNonPosBatchByGtin(),HttpStatus.OK);
//    }

}
