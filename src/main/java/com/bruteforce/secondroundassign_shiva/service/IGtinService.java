package com.bruteforce.secondroundassign_shiva.service;

import com.bruteforce.secondroundassign_shiva.dto.RequestGtinDto1;
import com.bruteforce.secondroundassign_shiva.dto.ResponseGtinDto1;
import com.bruteforce.secondroundassign_shiva.dto.ResponseGtinDto2;

import java.util.List;

public interface IGtinService {

    ResponseGtinDto1 createGtin(RequestGtinDto1 reqDto);

    List<ResponseGtinDto1> createGtins(List<RequestGtinDto1> list);

    List<ResponseGtinDto2> getAllGtins();
    List<String> findAllGtinsContainingBatchAvailableQuantityPositive();
}
