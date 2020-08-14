package com.bms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.model.t_batch_details;

@Repository
public interface Batch_detailsRepo extends JpaRepository<t_batch_details, Long>{

}
