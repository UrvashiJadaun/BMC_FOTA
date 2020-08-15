package com.bms.service.impl;


import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bms.DTO.UserDTO;
import com.bms.Entity.OrganisationEntity;
/*import com.bms.jdbctemplate.BatteryJdbcTamplateRepo;
import com.bms.repo.AssetRepo;*/
import com.bms.repo.CustomerTableRepo;
import com.bms.repo.OrganisationRepo;
import com.bms.repo.PlainOrganisationResponseRepo;
import com.bms.repo.UserRepo;
import com.bms.service.OrganisationServiceAPI;
/*import com.bms.service.UserServiceAPI;*/
import com.bms.util.TokenParser;

@Service
public class OrganisationServiceimpl implements OrganisationServiceAPI{

	@Autowired
	private OrganisationRepo repository;
	
	@Autowired
	UserRepo userRepo;
	/*
	 * @Autowired private UserServiceAPI userservice;
	 */
	
	@Autowired
	TokenParser tokenParse;
	
	@Autowired
	CustomerTableRepo customertable;
	
	@Autowired PlainOrganisationResponseRepo orgWithout;
	

	/*
	 * @Autowired private AssetRepo assetrepo;
	 */
	
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<OrganisationEntity> findOrgDetailsByToken(String accessToken) {
		UserDTO userdetailsFromToken = tokenParse.getUserdetailsFromToken(accessToken);
		
		return repository.findById(userdetailsFromToken.getOrgid());
	}

}
