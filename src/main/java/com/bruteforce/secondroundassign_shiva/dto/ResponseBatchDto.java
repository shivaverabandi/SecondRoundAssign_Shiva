package com.bruteforce.secondroundassign_shiva.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBatchDto {

    private Long batchId;
    private Integer mrp;
    private String batchName;
    private Integer sp;
    private Integer purchasePrice;
    private Integer availableQuantity;
    private Date inWardedOn;
    private GtinDtoBatch gtin;

}
