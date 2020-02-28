package com.phonebridge.portalservice.db.mongo.v1.row.campaign;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document(collection ="campaign")
@Data
@Builder
public class MongoCampaignRow {

	private ObjectId accountId;
	
	@Id
	private ObjectId campaignId;
	
	private String campaignName;
	private String callDirection;
	private String campaignStatus;
	private boolean isEnabledForPopup;
	/* Defines the type of Campaign */
	private String typeOfCall;
	/* Default campaigns are generic those which don't fit into other campaigns */
	private boolean isDefault;
	
	private MongoCampaignIncomingSettings campaignIncomingSettings;
	private MongoCampaignOutgoingSettings campaignOutgoingSettings;
	private MongoCampaignPopup campaignPopup;

}
