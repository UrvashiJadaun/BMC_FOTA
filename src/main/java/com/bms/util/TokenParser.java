package com.bms.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bms.DTO.UserDTO;
import com.bms.Entity.UserEntity;
import com.bms.repo.UserRepo;
import com.bms.security.JwtTokenUtil;

@Component
public class TokenParser {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserRepo userRepo;

	static ModelMapper modelMapper = new ModelMapper();

	/*
	 * public static UserEntity getUserdetailsFromToken(String accessToken) {
	 * accessToken = accessToken.substring(7); String username =
	 * jwtTokenUtil.getUsernameFromToken(accessToken); return
	 * userRepo.findByUsername(username);
	 * 
	 * }
	 * 
	 * public static int getOrgIdFromToken(String accessToken) { UserEntity
	 * userdetailsFromToken = getUserdetailsFromToken(accessToken);
	 * 
	 * return userdetailsFromToken.getOrgId();
	 * 
	 * }
	 * 
	 * public static int getUserIdFromToken(String accessToken) { UserEntity
	 * userdetailsFromToken = getUserdetailsFromToken(accessToken);
	 * 
	 * return userdetailsFromToken.getId();
	 * 
	 * }
	 */

	public UserDTO getUserdetailsFromToken(String accessToken) {
		//System.err.println(accessToken);
		accessToken = accessToken.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(accessToken);
		UserEntity user = userRepo.findByUsername(username);
		UserDTO dto = modelMapper.map(user, UserDTO.class);
		return dto;

	}

	public String getUsernameFromToken(String accessToken) {
		accessToken = accessToken.substring(7);
		return jwtTokenUtil.getUsernameFromToken(accessToken);

	}

}
