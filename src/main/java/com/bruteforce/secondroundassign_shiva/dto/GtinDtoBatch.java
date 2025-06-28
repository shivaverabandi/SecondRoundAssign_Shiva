package com.bruteforce.secondroundassign_shiva.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GtinDtoBatch {

    // used this Dto in ResponseBatchDto to return gtinName after saving Batch in Database
    private Long gtinId;
    private String gtinName;
}
