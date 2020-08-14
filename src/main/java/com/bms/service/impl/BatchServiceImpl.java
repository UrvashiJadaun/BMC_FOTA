package com.bms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.model.t_batch;
import com.bms.repo.BatchRepo;
import com.bms.service.BatchServiceApi;

@Service
public class BatchServiceImpl implements BatchServiceApi{
	
	@Autowired
	BatchRepo batchRepo;

	@Override
	public void saveBatchRecords(t_batch batch) {

		batchRepo.save(batch);
	}


}
