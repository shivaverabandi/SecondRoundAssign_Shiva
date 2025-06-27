package com.bruteforce.secondroundassign_shiva.service;

import com.bruteforce.secondroundassign_shiva.dto.GtinDto;

import java.util.List;

public interface IGtinService {

    GtinDto createGtin(GtinDto reqDto);

    GtinDto getGtinBy(String gtin);

    List<GtinDto> getAll();

    List<String> gtinsWhoseBatchQauntIsPos();
}
