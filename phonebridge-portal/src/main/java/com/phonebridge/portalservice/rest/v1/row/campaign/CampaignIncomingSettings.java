package com.phonebridge.portalservice.rest.v1.row.campaign;

import java.util.List;

import lombok.Data;

@Data
public class CampaignIncomingSettings {
	/********************************************************************************************
	 * Incoming Specific
	 *******************************************************************************************/
	/* Incoming: For making DID based campaigns */
	private List<String> didNumbers;
	
	/* Incoming: For making Queue based campaigns */
	private List<String> queueNames;
	
	/* Configured to send CDRs when received */
	private String ctiPostBackUrl;
}
