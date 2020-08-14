package com.bms.service.impl;

import java.text.SimpleDateFormat;import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bms.Entity.AssetEntity;
import com.bms.repo.AssetRepo;

import com.bms.service.AssetsServiceAPI;
//import com.bms.services.AssetsServiceAPI;


@Service
public class AssetsServiceImpl implements AssetsServiceAPI {

	/*
	 * @Autowired private ModelMapperUtil modelMapperUtil;
	 */

	@Autowired
	private AssetRepo assetRepo;

	@Override
	public List<AssetEntity> findAllAssets() {
		System.out.println("Inside AssetsServiceImpl");
		return assetRepo.findAll();
	}

	
}
