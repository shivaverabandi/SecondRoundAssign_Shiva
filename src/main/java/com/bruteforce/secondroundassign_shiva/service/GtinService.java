package com.bruteforce.secondroundassign_shiva.service;

import com.bruteforce.secondroundassign_shiva.Exceptions.GtinAleardyExists;
import com.bruteforce.secondroundassign_shiva.Exceptions.GtinNotExists;
import com.bruteforce.secondroundassign_shiva.Exceptions.ProductNotExists;
import com.bruteforce.secondroundassign_shiva.dto.GtinDto;
import com.bruteforce.secondroundassign_shiva.model.Gtin;
import com.bruteforce.secondroundassign_shiva.model.Product;
import com.bruteforce.secondroundassign_shiva.repo.IGtinRepo;
import com.bruteforce.secondroundassign_shiva.repo.IProductRepo;
import com.bruteforce.secondroundassign_shiva.utils.DtoEntityMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public GtinDto createGtin(GtinDto reqDto){

        Optional<Product> product =prodRepo.findById(reqDto.getProduct().getProductId());
        if(product.isEmpty()){
            throw new ProductNotExists("Product is not exists in Database..!");
        }

        Optional<Gtin> gtin = repo.findByGtin((reqDto.getGtin()));
        if(gtin.isEmpty()){
            Gtin newGtin = DtoEntityMapperUtil.toEntity(reqDto, product.get());
            newGtin = repo.save(newGtin);
            return DtoEntityMapperUtil.toDto(newGtin);
        }

        throw new GtinAleardyExists("Gtin With name "+reqDto.getGtin()+" already exits..!");
    }

    @Override
    public GtinDto getGtinBy(String gtin) {
        Optional<Gtin> response  = repo.findByGtin(gtin);
        if(response.isPresent()) {
            GtinDto resDto = DtoEntityMapperUtil.toDto(response.get());
            return resDto;
        }
        throw new GtinNotExists("Gtin with name "+ gtin + "Not Exists..!");
    }

    @Override
    public List<GtinDto> getAll(){
        List<Gtin> list = repo.findAll();
        List<GtinDto> gtinDto =  list.stream().map(gtin -> DtoEntityMapperUtil.toDto(gtin))
                .toList();
        return gtinDto;
    }

    @Override
    public List<String> gtinsWhoseBatchQauntIsPos() {
        return repo.findAllGtinsWithPositiveBatchQuantity();
    }


}
