package com.bruteforce.secondroundassign_shiva.service;

import com.bruteforce.secondroundassign_shiva.dto.RequestBatchDto;
import com.bruteforce.secondroundassign_shiva.dto.ResponseBatchDto;

public interface IBatchService {

    ResponseBatchDto createBatch(RequestBatchDto reqDto);

 //   BatchDto findNonPosBatchByGtin();
}
