package com.bruteforce.secondroundassign_shiva.service;

import com.bruteforce.secondroundassign_shiva.dto.BatchDto;

public interface IBatchService {

    BatchDto createBatch(BatchDto reqDto);

    BatchDto findNonPosBatchByGtin();
}
