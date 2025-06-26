package com.bruteforce.secondroundassign_shiva.repo;

import com.bruteforce.secondroundassign_shiva.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBatchRepo extends JpaRepository<Batch,Long> {

}
