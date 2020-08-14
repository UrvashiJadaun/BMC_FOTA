package com.bms.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.bms.Entity.AssetEntity;

@Service
public interface AssetsServiceAPI {
	
	public List<AssetEntity> findAllAssets();

}
