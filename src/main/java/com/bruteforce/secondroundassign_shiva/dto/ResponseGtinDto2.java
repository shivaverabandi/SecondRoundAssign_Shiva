package com.bruteforce.secondroundassign_shiva.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A Data Transfer Object (DTO) class used to represent a concise response structure
 * for GTIN (Global Trade Item Number) data being sent to the client.
 *
 * This class contains only specific fields that should be returned to the client,
 * helping to simplify and clarify the GTIN data retrieved from the database.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGtinDto2 {
    // used to control the fields while retrieve all rows of gtins
    // This Dto responsible for sent only these fields to client for clarity.
    private Long gtinId;
    private String gtinName;
    private ProductDto product;
}
