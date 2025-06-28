package com.bruteforce.secondroundassign_shiva.service;

import com.bruteforce.secondroundassign_shiva.Exceptions.GtinAleardyExists;
import com.bruteforce.secondroundassign_shiva.Exceptions.ProductNotExists;
import com.bruteforce.secondroundassign_shiva.dto.RequestGtinDto1;
import com.bruteforce.secondroundassign_shiva.dto.ResponseGtinDto1;
import com.bruteforce.secondroundassign_shiva.dto.ResponseGtinDto2;
import com.bruteforce.secondroundassign_shiva.model.Gtin;
import com.bruteforce.secondroundassign_shiva.model.Product;
import com.bruteforce.secondroundassign_shiva.repo.IGtinRepo;
import com.bruteforce.secondroundassign_shiva.repo.IProductRepo;
import com.bruteforce.secondroundassign_shiva.utils.GtinDto1Converter;
import com.bruteforce.secondroundassign_shiva.utils.GtinDto2Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GtinService implements IGtinService {

    private IGtinRepo repo;
    private IProductRepo prodRepo;

    @Autowired
    public GtinService(IGtinRepo repo, IProductRepo prodRepo){
        this.repo = repo;
        this.prodRepo = prodRepo;
    }


    @Override
    public ResponseGtinDto1 createGtin(RequestGtinDto1 reqDto){

        Product product =prodRepo.findById(reqDto.getProductId())
                .orElseThrow(() -> new ProductNotExists("Product not found with "+ reqDto.getProductId()));

        Optional<Gtin> gtin = repo.findByGtinName((reqDto.getGtinName()));
        if(gtin.isEmpty()){
            Gtin newGtin = GtinDto1Converter.convertToEntity(reqDto,product);
            newGtin = repo.save(newGtin);
            return GtinDto1Converter.convertToDto(newGtin);
        }

        throw new GtinAleardyExists("Gtin With name "+reqDto.getGtinName() +" already exits..!");
    }

    @Override
    public List<ResponseGtinDto1> createGtins(List<RequestGtinDto1> list) {
        List<Long> prods = new ArrayList<>();
        for(RequestGtinDto1 req : list){
            prods.add(req.getProductId()); // adding the products id to list for checking
        }
        List<Product> prodList = prodRepo.findAllById(prods);

        if(prodList.size() != list.size()){ // checking that product is valid or not
            throw new ProductNotExists("Gtin is Dependent on Product, So provide valid Product ID which is Database already");
        }

        for(RequestGtinDto1 req : list){ // chceking that given gitns are unique or not.
            if(!repo.findByGtinName(req.getGtinName()).isEmpty()){ // Checking the products are already there are not, if there continue.
                throw new GtinAleardyExists("Gtin With name "+req.getGtinName() +" already exits..!");
            }
        }

        List<Gtin> saveEntityList = new ArrayList<>();
        for(RequestGtinDto1 reqDto : list){
            Gtin newGtin = GtinDto1Converter.convertToEntity(reqDto,prodRepo.findById(reqDto.getProductId()).get());
            saveEntityList.add(newGtin);
        }
        saveEntityList = repo.saveAll(saveEntityList);
        return saveEntityList.stream().map(gtin -> GtinDto1Converter.convertToDto(gtin)).toList();
    }

    @Override
    public List<ResponseGtinDto2> getAllGtins() {
        List<Gtin> gtins = repo.findAll();
        List<ResponseGtinDto2> response = gtins.stream()
                .map(gtin -> GtinDto2Converter.convertToDto2(gtin)).toList();
        return response;
    }

    @Override
    public List<String> findAllGtinsContainingBatchAvailableQuantityPositive() {
        return repo.findAllGtinsWithPositiveBatchQuantity();
    }

}
