package com.bruteforce.secondroundassign_shiva.service;

import com.bruteforce.secondroundassign_shiva.Exceptions.BatchAlreadyExists;
import com.bruteforce.secondroundassign_shiva.Exceptions.BatchNotFoundException;
import com.bruteforce.secondroundassign_shiva.Exceptions.GtinNotExists;
import com.bruteforce.secondroundassign_shiva.dto.RequestBatchDto;
import com.bruteforce.secondroundassign_shiva.dto.ResponseBatchDto;
import com.bruteforce.secondroundassign_shiva.model.Batch;
import com.bruteforce.secondroundassign_shiva.model.Gtin;
import com.bruteforce.secondroundassign_shiva.repo.IBatchRepo;
import com.bruteforce.secondroundassign_shiva.repo.IGtinRepo;
import com.bruteforce.secondroundassign_shiva.utils.BatchDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BatchService implements IBatchService{

    private IBatchRepo batchRepo;
    private IGtinRepo gtinRepo;

    @Autowired
    public BatchService(IBatchRepo batchRepo, IGtinRepo gtinRepo){
        this.batchRepo = batchRepo;
        this.gtinRepo = gtinRepo;
    }
    @Override
    public ResponseBatchDto createBatch(RequestBatchDto reqDto) {

        Gtin gtin = gtinRepo.findById(reqDto.getGtinId())
                .orElseThrow(() -> new GtinNotExists("Gtin not exists with given" + reqDto.getGtinId()));

        Optional<Batch> b = batchRepo.findByBatchName(reqDto.getBatchName());
        if(b.isEmpty()){
            Batch newBatch = BatchDtoConverter.convertToEntity(reqDto, gtin);
            newBatch = batchRepo.save(newBatch);
            return BatchDtoConverter.convertToDto(newBatch);
        }
        throw new BatchAlreadyExists("Batch already exists with name : "+ reqDto.getBatchName());
    }

    @Override
    public ResponseBatchDto getNonPositiveBatchBasedOnLatestInWardedFilter() {
        Batch response = batchRepo.findNonPositiveBatchBasedOnLatestInWardedFilter()
                .orElseThrow(() -> new BatchNotFoundException("Batch Based on this scenario not exists or not found..!"));
        return BatchDtoConverter.convertToDto(response);
    }

}
