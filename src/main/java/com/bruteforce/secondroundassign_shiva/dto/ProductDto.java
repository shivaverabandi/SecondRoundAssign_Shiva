package com.bruteforce.secondroundassign_shiva.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long productId;
    private String productName;
    private Date createdOn;
    private List<Integer> gtinIds;

}
