package com.bruteforce.secondroundassign_shiva.repo;

import com.bruteforce.secondroundassign_shiva.model.Gtin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IGtinRepo extends JpaRepository<Gtin,Integer> {

    Optional<Gtin> findByGtin(String gtin);

    @Query("SELECT DISTINCT g.gtin FROM Gtin g JOIN g.batches b WHERE b.availableQuantity > 0")
    List<String> findAllGtinsWithPositiveBatchQuantity();
}
