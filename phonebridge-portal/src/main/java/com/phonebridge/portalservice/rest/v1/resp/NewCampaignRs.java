package com.phonebridge.portalservice.rest.v1.resp;

import lombok.Data;

@Data
public class NewCampaignRs extends BaseResp{
	String campaignId;
	Status respStatus;
}
