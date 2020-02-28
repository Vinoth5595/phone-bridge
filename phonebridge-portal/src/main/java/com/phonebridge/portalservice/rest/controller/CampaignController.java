package com.phonebridge.portalservice.rest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.phonebridge.portalservice.rest.v1.req.NewCampaignRq;
import com.phonebridge.portalservice.rest.v1.resp.NewCampaignRs;
import com.phonebridge.portalservice.rest.v1.util.CampaignUtil;
import com.phonebridge.portalservice.service.ICampaignService;
import com.phonebridge.row.campaign.Campaign;

@RestController
@RequestMapping(path = "/campaign/v1")
public class CampaignController {

	@Autowired
	ICampaignService service;
		
	@Autowired
	Environment env;

	
	@PostMapping(path =  "/newCampaign",produces="application/json",consumes="application/json")
	public @ResponseBody ResponseEntity<NewCampaignRs> insertCampaign(
			 @RequestHeader("accountId") String accountId
			,@RequestHeader("userId") String userId 
			,@RequestBody NewCampaignRq newCampaignRq) {
		Map<String,String> validationResults= CampaignUtil.validateSaveCampaign(newCampaignRq);
		if(!validationResults.isEmpty()){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		Campaign campaign = CampaignUtil.convertIntoCampaign(accountId,userId,newCampaignRq);
		String campaignId=service.saveData(campaign);
		NewCampaignRs response= CampaignUtil.convertIntoNewCampaignRs(campaignId);
		
		String runningPortNumber=(env.getProperty("local.server.port"));

		
		response.setRequestId(newCampaignRq.getRequestId()+"-"+runningPortNumber);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}

}
