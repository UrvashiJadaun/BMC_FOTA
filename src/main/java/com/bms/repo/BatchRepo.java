package com.bms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.model.t_batch;

@Repository
public interface BatchRepo extends JpaRepository<t_batch,Long> {

}
