package com.phonebridge.portalservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.phonebridge.portalservice.db.mongo.ICampaignDBService;
import com.phonebridge.row.campaign.Campaign;

@Service
public class CampaignServiceImpl implements ICampaignService{
	
	@Autowired
	@Qualifier("campaignMongoRepositoryImpl")
	ICampaignDBService repository;
	
	@Override
	public String saveData(Campaign campaign) {
		return repository.saveCampaign(campaign);
	}
	
	/*
	 * public Campaign updateCampaignByName(String name) { mongoTemplate.u }
	 */
}
