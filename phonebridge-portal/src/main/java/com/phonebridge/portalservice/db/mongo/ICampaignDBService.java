package com.phonebridge.portalservice.db.mongo;

import com.phonebridge.row.campaign.Campaign;

public interface ICampaignDBService {
	String saveCampaign(Campaign campaign);
}
