package com.phonebridge.portalservice.db.mongo.v1.row.campaign;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MongoCampaignIncomingSettings {
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
