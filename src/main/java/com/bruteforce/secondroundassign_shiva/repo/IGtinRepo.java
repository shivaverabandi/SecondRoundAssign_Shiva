package com.bruteforce.secondroundassign_shiva.repo;

import com.bruteforce.secondroundassign_shiva.model.Gtin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IGtinRepo extends JpaRepository<Gtin,Long> {

    Optional<Gtin> findByGtinName(String gtin);

//    @Query("SELECT DISTINCT g.gtin FROM Gtin g JOIN g.batches b WHERE b.availableQuantity > 0")
//    List<String> findAllGtinsWithPositiveBatchQuantity();
}
