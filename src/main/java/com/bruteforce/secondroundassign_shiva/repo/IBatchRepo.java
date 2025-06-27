package com.bruteforce.secondroundassign_shiva.repo;

import com.bruteforce.secondroundassign_shiva.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBatchRepo extends JpaRepository<Batch,Integer> {

    Optional<Batch> findByBatchName(String batchName);

    @Query("SELECT b FROM Batch b WHERE   b.availableQuantity <=0 ORDER BY b.inwardedOn DESC LIMIT 1")
    Optional<Batch> findNonPosBatchByGtin();
}
