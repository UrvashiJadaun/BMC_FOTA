package com.bms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.model.t_batch_details;
import com.bms.repo.Batch_detailsRepo;
import com.bms.service.BatchDetailsServiceApi;

@Service
public class BatchDetailsImpl implements BatchDetailsServiceApi{

	@Autowired
	Batch_detailsRepo batch_detailsRepo;
	@Override
	public void saveBatchDetailsRecords(t_batch_details batch_details) {

		batch_detailsRepo.save(batch_details);
	}

}
