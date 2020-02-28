package com.phonebridge.portalservice.db.mongo.v1.row.campaign;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MongoCampaignOutgoingSettings {

	/********************************************************************************************
	 * Outgoing Specific
	 *******************************************************************************************/
	/* This is to provision map a list of numbers to particular extensions */
	private boolean isExtensionWise;
	
	/* In case the customer doesn't pick up, how many times should we retry */
	private int noOfClientTries;

	/* In case the agent doesn't pick up, how many times should we retry the agent */
	private int noOfAgentTries;

	/* In case the customer didn't pick up, after how much interval it has to be scheduled for retry */
	private int retryAfter;
	
	/* trunks involved in OG campaign */
	private List<String> trunkName;
	
	/* Prefix to use for Dialing out */
	private String prefix;
	
	/* How many seconds to wait after showing the popup before dialing out */
	private int dialOutWaitTimeInSecs;
}
