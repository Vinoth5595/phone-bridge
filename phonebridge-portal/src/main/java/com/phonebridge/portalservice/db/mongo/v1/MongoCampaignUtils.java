package com.phonebridge.portalservice.db.mongo.v1;

import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import com.phonebridge.portalservice.db.mongo.v1.row.campaign.Disposition;
import com.phonebridge.portalservice.db.mongo.v1.row.campaign.MongoCampaignIncomingSettings;
import com.phonebridge.portalservice.db.mongo.v1.row.campaign.MongoCampaignOutgoingSettings;
import com.phonebridge.portalservice.db.mongo.v1.row.campaign.MongoCampaignPopup;
import com.phonebridge.portalservice.db.mongo.v1.row.campaign.MongoCampaignRow;
import com.phonebridge.portalservice.db.mongo.v1.row.campaign.ShowField;
import com.phonebridge.row.campaign.Campaign;
import com.phonebridge.row.campaign.EnumAssocDirection;
import com.phonebridge.row.campaign.EnumTypeOfCall;

@Component
public class MongoCampaignUtils {
	
	public static MongoCampaignRow convertIntoMongoCampaign(Campaign campaign) {
		if(campaign == null) {
			return null;
		}
		ObjectId campaignId = new ObjectId(); 
		MongoCampaignRow mongoCampaignRow =  MongoCampaignRow.builder()
			.accountId(new ObjectId(campaign.getAccount().getAccountId()))
			.campaignId(campaignId)
		 	.campaignName(isNotNull(campaign.getCampaignName()) ? campaign.getCampaignName() : "")
		 	.callDirection(EnumAssocDirection.getAssocDirection(campaign.getCallDirection().toString()).toString())
		 	.campaignStatus(isNotNull(campaign.getCampaignStatus().toString()) ? campaign.getCampaignStatus().toString() : "")
		 	.isEnabledForPopup(campaign.isEnabledForPopup())
		 	.typeOfCall(EnumTypeOfCall.getTypeOfCall(campaign.getTypeOfCall().toString()).toString())
		 	.isDefault(campaign.isDefault()).build();
		
		//Set the value for incoming
		Optional.ofNullable(campaign.getCampaignIncomingSettings()).ifPresent(
				campaignIncomingRow -> {
				   MongoCampaignIncomingSettings mongoCampaignIncomingSettings = MongoCampaignIncomingSettings
																			     .builder()
							                                                     .ctiPostBackUrl(campaignIncomingRow.getCtiPostBackUrl())
							                                                     .didNumbers(campaignIncomingRow.getDidNumbers())
							                                                     .queueNames(campaignIncomingRow.getQueueNames()).build();
					mongoCampaignRow.setCampaignIncomingSettings(mongoCampaignIncomingSettings);
				});
		
		//Set the value for outgoing
		Optional.ofNullable(campaign.getCampaignOutgoingSettings()).ifPresent(
				campaignOutgoingRow -> {
					MongoCampaignOutgoingSettings mongoCampaignOutgoingSettings = MongoCampaignOutgoingSettings.builder()
																				  .dialOutWaitTimeInSecs(campaignOutgoingRow.getDialOutWaitTimeInSecs())
																				  .noOfAgentTries(campaignOutgoingRow.getNoOfAgentTries())
																				  .prefix(campaignOutgoingRow.getPrefix())
																				  .retryAfter(campaignOutgoingRow.getRetryAfter())
																				  .trunkName(campaignOutgoingRow.getTrunkName()).build();
					mongoCampaignRow.setCampaignOutgoingSettings(mongoCampaignOutgoingSettings);
				});
		
		//Set the value for mongo campaign POP Up
		Optional.ofNullable(campaign.getCampaignPopup()).ifPresent(
				campaignPopupRow -> {
					MongoCampaignPopup.builder()
									  .moduleName(isNotNull(campaignPopupRow.getModuleName()) ? campaignPopupRow.getModuleName() : "")
									  .directoryInfoURL(isNotNull(campaignPopupRow.getDirectoryInfoURL()) ? campaignPopupRow.getDirectoryInfoURL() : "")
									  .wrapUpTimeInSecs(campaignPopupRow.getWrapUpTimeInSecs())
									  .campaignFeedSource(isNotNull(campaignPopupRow.getCampaignFeedSource().toString()) ? campaignPopupRow.getCampaignFeedSource().toString(): "")
									  .dispositions(campaignPopupRow.getDispositions()
											  .stream()
											  .filter(campdisp -> campdisp != null)
											  .map(campdisp -> {
												  	Disposition disp = Disposition.builder()
																		.dispositionID(campdisp.getDispositionID())
																		.fieldDataType(campdisp.getFieldDataType().toString())
																		.fieldLabel(campdisp.getFieldLabel())
																		.callWorkFlow(campdisp.getCallWorkFlow())
																		.sendSMS(campdisp.isSendSMS())
																		.smsText(campdisp.getSmsText())
																		.conversion(campdisp.isConversion())
																		.dropDownValues(campdisp.getDropDownValues()).build();	
												  	return disp;
												}).collect(Collectors.toList()))
									  .showFields(campaignPopupRow.getShowFields()
									  			.stream()
									  			.filter(campPopupRow -> campaignPopupRow != null)
									  			.map(campPopupRow -> 
									  			{
									  				ShowField showField = ShowField.builder()
															  				.showFieldID(campPopupRow.getShowFieldID())
															  				.fieldLabel(campPopupRow.getFieldLabel())
															  				.displayField(campPopupRow.getDisplayField())
															  				.isUrl(campPopupRow.isUrl()).build();
									  				return showField;
									  			}).collect(Collectors.toList()))
									  .build();			
									  			
											  
				}
		);
		return mongoCampaignRow;
	}

	
	public static boolean isNotNull(String value) {
		 return Optional.ofNullable(value).isPresent();
	}
	
	public static void main(String[] args) {
		System.out.println(isNotNull("Hello"));
	}
	
}
