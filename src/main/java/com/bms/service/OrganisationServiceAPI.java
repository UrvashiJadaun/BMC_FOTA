package com.bms.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.bms.Entity.OrganisationEntity;


@Component
public interface OrganisationServiceAPI {

	/*
	 * public GridDataResponse<OrganisationResponse>
	 * getAllOrganisationsByOrgAndActiveWithPagination(int page, int size, String
	 * columnName, String order, boolean activeYN, String accessToken);
	 */
	public Optional<OrganisationEntity> findOrgDetailsByToken(String accessToken);

}
