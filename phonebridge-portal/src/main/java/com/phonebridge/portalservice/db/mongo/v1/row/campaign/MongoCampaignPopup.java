package com.phonebridge.portalservice.db.mongo.v1.row.campaign;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MongoCampaignPopup {
	
	private String moduleName;
	
	/* Directory URL to get info about an IC number / OG No */ 
	private String directoryInfoURL;
	
	/* No of seconds before the Popup is wrapped Up automatically */
	private int wrapUpTimeInSecs;
	
	private String campaignFeedSource;
	
	private List<Disposition> dispositions;
	private List<ShowField> showFields;
	
	private MongoCampaignPopupIncoming campaignPopupIncoming;
	
	private MongoCampaignPopupOutgoing campaignPopupOutgoing;
}
