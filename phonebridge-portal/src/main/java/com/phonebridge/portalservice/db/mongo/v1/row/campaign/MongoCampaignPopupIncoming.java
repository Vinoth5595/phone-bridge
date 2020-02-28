package com.phonebridge.portalservice.db.mongo.v1.row.campaign;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MongoCampaignPopupIncoming {
	
	/* In case we need to show external URL specific to customer numbers like portal info */
	private String iFrameUrl;
}
