package com.bruteforce.secondroundassign_shiva.service;

import com.bruteforce.secondroundassign_shiva.Exceptions.BatchAlreadyExists;
import com.bruteforce.secondroundassign_shiva.Exceptions.BatchNotFoundException;
import com.bruteforce.secondroundassign_shiva.Exceptions.GtinNotExists;
import com.bruteforce.secondroundassign_shiva.dto.BatchDto;
import com.bruteforce.secondroundassign_shiva.model.Batch;
import com.bruteforce.secondroundassign_shiva.model.Gtin;
import com.bruteforce.secondroundassign_shiva.repo.IBatchRepo;
import com.bruteforce.secondroundassign_shiva.repo.IGtinRepo;
import com.bruteforce.secondroundassign_shiva.utils.DtoEntityMapperUtil;
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
    public BatchDto createBatch(BatchDto reqDto) {
        Optional<Gtin> gtin = gtinRepo.findById(reqDto.getGtinId());
        if(gtin.isEmpty()){
            throw new GtinNotExists("Gtin With Id "+reqDto.getGtinId() + " not exits..!");
        }
        Optional<Batch> b = batchRepo.findByBatchName(reqDto.getBatchName());
        if(b.isEmpty()){
            Batch newBatch = DtoEntityMapperUtil.toEntity(reqDto, gtin.get());
            newBatch = batchRepo.save(newBatch);
            BatchDto responseDto = DtoEntityMapperUtil.toDto(newBatch);
            return responseDto;
        }
        throw new BatchAlreadyExists("Batch already exists with name : "+ reqDto.getBatchName());
    }

    @Override
    public BatchDto findNonPosBatchByGtin(){
        Optional<Batch> opBatch =  batchRepo.findNonPosBatchByGtin();
        if(opBatch.isEmpty()){
            throw new BatchNotFoundException("Batch Not found Exception..!");
        }

        BatchDto response = DtoEntityMapperUtil.toDto(opBatch.get());
        return response;
    }
}
