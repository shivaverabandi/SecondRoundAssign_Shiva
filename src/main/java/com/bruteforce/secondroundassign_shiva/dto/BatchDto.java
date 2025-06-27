package com.bruteforce.secondroundassign_shiva.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchDto {
    private Integer batchId;
    private Integer mrp;
    private Integer sp;
    private String batchName;
    private Integer purchasePrice;
    private Integer availableQuantity;
    private Date inwardedOn;
    private Integer gtinId;

}
