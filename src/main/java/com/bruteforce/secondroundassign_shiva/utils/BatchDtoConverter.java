package com.bruteforce.secondroundassign_shiva.utils;

import com.bruteforce.secondroundassign_shiva.dto.GtinDtoBatch;
import com.bruteforce.secondroundassign_shiva.dto.RequestBatchDto;
import com.bruteforce.secondroundassign_shiva.dto.ResponseBatchDto;
import com.bruteforce.secondroundassign_shiva.model.Batch;
import com.bruteforce.secondroundassign_shiva.model.Gtin;

public class BatchDtoConverter {

    public static Batch convertToEntity(RequestBatchDto dto, Gtin gtin) {
        Batch batch = new Batch();
        batch.setMrp(dto.getMrp());
        batch.setBatchName(dto.getBatchName());
        batch.setSp(dto.getSp());
        batch.setPurchasePrice(dto.getPurchasePrice());
        batch.setAvailableQuantity(dto.getAvailableQuantity());
        batch.setInWardedOn(dto.getInWardedOn());
        batch.setGtin(gtin);
        return batch;
    }

    public static ResponseBatchDto convertToDto(Batch batch) {
        ResponseBatchDto dto = new ResponseBatchDto();
        dto.setBatchId(batch.getBatchId());
        dto.setBatchName(batch.getBatchName());
        dto.setMrp(batch.getMrp());
        dto.setSp(batch.getSp());
        dto.setAvailableQuantity(batch.getAvailableQuantity());
        dto.setInWardedOn(batch.getInWardedOn());
        dto.setPurchasePrice(batch.getPurchasePrice());
        dto.setGtin(new GtinDtoBatch(batch.getGtin().getGtinId(), batch.getGtin().getGtinName()));
        return dto;
    }
}
