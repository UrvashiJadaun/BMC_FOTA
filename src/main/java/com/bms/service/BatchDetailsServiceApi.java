package com.bms.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bms.model.t_batch_details;

@Component
public interface BatchDetailsServiceApi {
	public void saveBatchDetailsRecords(t_batch_details batch_details);

}
