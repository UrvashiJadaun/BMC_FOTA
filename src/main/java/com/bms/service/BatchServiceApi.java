package com.bms.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bms.model.t_batch;

@Component
public interface BatchServiceApi {

	public void saveBatchRecords(t_batch batch);
}
