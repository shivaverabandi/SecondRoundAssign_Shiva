package com.bruteforce.secondroundassign_shiva.weblayer;

import com.bruteforce.secondroundassign_shiva.dto.GtinDto;
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
    public ResponseEntity<GtinDto> createBatch(@RequestBody GtinDto reqDto){
        return new ResponseEntity<>(service.createGtin(reqDto), HttpStatus.CREATED);
    }

    @GetMapping("/get-gtinBy/{gtin}")
    public ResponseEntity<GtinDto> getGtinBy(@PathVariable String gtin){
        return new ResponseEntity<>(service.getGtinBy(gtin),HttpStatus.OK);
    }

    @GetMapping("/get-all-gtins")
    public ResponseEntity<List<GtinDto>> getAll(){
        List<GtinDto> gtins = service.getAll();
        if(gtins.isEmpty())
            return new ResponseEntity<>(gtins,HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(gtins,HttpStatus.OK);
    }

    @GetMapping("/get-gtins-pos-batch")
    public ResponseEntity<List<String>> findAllGtinsWhosebatchPos(){
        List<String> list = service.gtinsWhoseBatchQauntIsPos();
        if(list.isEmpty()) return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
        return  new ResponseEntity<>(list, HttpStatus.OK);
    }
}
