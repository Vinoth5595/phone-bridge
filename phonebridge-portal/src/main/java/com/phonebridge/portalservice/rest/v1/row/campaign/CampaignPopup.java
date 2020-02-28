package com.phonebridge.portalservice.rest.v1.row.campaign;

import java.util.List;

import lombok.Data;

@Data
public class CampaignPopup {
	
	private String moduleName;
	
	/* Directory URL to get info about an IC number / OG No */ 
	private String directoryInfoURL;
	
	/* No of seconds before the Popup is wrapped Up automatically */
	private int wrapUpTimeInSecs;
	
	private String campaignFeedSource;
	
	private List<Disposition> dispositions;
	private List<ShowField> showFields;
	
	private CampaignPopupIncoming campaignPopupIncoming;
	
	private CampaignPopupOutgoing campaignPopupOutgoing;
}
