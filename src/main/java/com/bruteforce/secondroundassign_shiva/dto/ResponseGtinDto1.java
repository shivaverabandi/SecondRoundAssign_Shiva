package com.bruteforce.secondroundassign_shiva.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGtinDto1 {
    private Long gtinId;
    private String gtinName;
    private ProductDto product;
}
