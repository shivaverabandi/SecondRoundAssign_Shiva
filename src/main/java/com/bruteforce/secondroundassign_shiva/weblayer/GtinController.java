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

    private IGtinService service;

    @Autowired
    public GtinController(IGtinService service){
        this.service = service;
    }
    @PostMapping("/create-gtin")
    public ResponseEntity<ResponseGtinDto1> createGtin(@RequestBody RequestGtinDto1 reqDto){
        return new ResponseEntity<>(service.createGtin(reqDto), HttpStatus.CREATED);
    }

    @PostMapping("/create-gtins")
    public ResponseEntity<List<ResponseGtinDto1>> createGtins(@RequestBody List<RequestGtinDto1> list){
        return new ResponseEntity<>(service.createGtins(list), HttpStatus.CREATED);
    }

    @GetMapping("/get-all-gtins")
    public ResponseEntity<List<ResponseGtinDto2>> getAllGtins(){
        List<ResponseGtinDto2> list = service.getAllGtins();
        if(list.isEmpty())
            return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
