package com.phonebridge.portalservice.rest.v1.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.phonebridge.portalservice.rest.v1.req.NewCampaignRq;
import com.phonebridge.portalservice.rest.v1.resp.NewCampaignRs;
import com.phonebridge.row.account.Account;
import com.phonebridge.row.campaign.Campaign;
import com.phonebridge.row.campaign.CampaignIncomingSettings;
import com.phonebridge.row.campaign.CampaignOutgoingSettings;
import com.phonebridge.row.campaign.CampaignPopup;
import com.phonebridge.row.campaign.CampaignPopupIncoming;
import com.phonebridge.row.campaign.Disposition;
import com.phonebridge.row.campaign.EnumAssocDirection;
import com.phonebridge.row.campaign.EnumCampaignSource;
import com.phonebridge.row.campaign.EnumDispositionDataType;
import com.phonebridge.row.campaign.EnumStatus;
import com.phonebridge.row.campaign.EnumTypeOfCall;
import com.phonebridge.row.campaign.ShowField;

public class CampaignUtil {
	
	public static NewCampaignRs convertIntoNewCampaignRs(String campaignId) {
		if(campaignId==null) {
			return null;
		}
		NewCampaignRs newCampaignRs = new NewCampaignRs();
		newCampaignRs.setCampaignId(campaignId);
		return newCampaignRs;
	}

	public static Campaign convertIntoCampaign(String accountId, String userId, NewCampaignRq ncr) {
		Campaign campaign=new Campaign();
		
		Account account = new Account();
		account.setAccountId(accountId);
		campaign.setAccount(account);
		
		campaign.setCampaignName(ncr.getCampaignName());
		campaign.setCallDirection(EnumAssocDirection.valueOf(ncr.getCallDirection()));
		campaign.setCampaignStatus(EnumStatus.valueOf(ncr.getCampaignStatus()));
		campaign.setEnabledForPopup(ncr.getIsEnabledForPopup());
		campaign.setTypeOfCall(EnumTypeOfCall.valueOf(ncr.getTypeOfCall()));
		campaign.setDefault(ncr.getIsDefault());
		
		if(campaign.isEnabledForPopup()) {
			CampaignPopup campaignPopup = new CampaignPopup();
			campaignPopup.setCampaignFeedSource(EnumCampaignSource.valueOf(ncr.getCampaignPopup().getCampaignFeedSource()));
			if(EnumCampaignSource.ModuleLinked == campaignPopup.getCampaignFeedSource()) {
				campaignPopup.setModuleName(ncr.getCampaignPopup().getModuleName());
			}
			if(ncr.getCampaignPopup().getDirectoryInfoURL()!=null && ncr.getCampaignPopup().getDirectoryInfoURL().length()>0) {
				campaignPopup.setDirectoryInfoURL(ncr.getCampaignPopup().getDirectoryInfoURL());
			}
			campaignPopup.setWrapUpTimeInSecs(ncr.getCampaignPopup().getWrapUpTimeInSecs());
			
			
			campaignPopup.setDispositions(copyDispositions(ncr.getCampaignPopup().getDispositions()));
			campaignPopup.setShowFields(copyShowFields(ncr.getCampaignPopup().getShowFields()));
			campaign.setCampaignPopup(campaignPopup);
			
			if(EnumAssocDirection.INCOMING == campaign.getCallDirection() 
					&& ncr.getCampaignPopup()!=null && ncr.getCampaignPopup().getCampaignPopupIncoming()!=null 
					&& ncr.getCampaignPopup().getCampaignPopupIncoming().getIFrameUrl()!=null) {
				CampaignPopupIncoming campaignPopupIncoming = new CampaignPopupIncoming();
				campaignPopupIncoming.setIFrameUrl(ncr.getCampaignPopup().getCampaignPopupIncoming().getIFrameUrl());
				campaignPopup.setCampaignPopupIncoming(campaignPopupIncoming);
			}
		}
		
		if(EnumAssocDirection.INCOMING == campaign.getCallDirection()) {
			CampaignIncomingSettings campaignIncomingSettings=new CampaignIncomingSettings();
			campaignIncomingSettings.setDidNumbers(ncr.getCampaignIncomingSettings().getDidNumbers());
			campaignIncomingSettings.setQueueNames(ncr.getCampaignIncomingSettings().getQueueNames());
			campaignIncomingSettings.setCtiPostBackUrl(ncr.getCampaignIncomingSettings().getCtiPostBackUrl());
			campaign.setCampaignIncomingSettings(campaignIncomingSettings);
		}
		if(EnumAssocDirection.OUTGOING == campaign.getCallDirection()) {
			CampaignOutgoingSettings campaignOutgoingSettings=new CampaignOutgoingSettings();
			campaignOutgoingSettings.setExtensionWise(ncr.getCampaignOutgoingSettings().getIsExtensionWise());
			campaignOutgoingSettings.setNoOfClientTries(ncr.getCampaignOutgoingSettings().getNoOfClientTries());
			campaignOutgoingSettings.setNoOfAgentTries(ncr.getCampaignOutgoingSettings().getNoOfAgentTries());
			campaignOutgoingSettings.setRetryAfter(ncr.getCampaignOutgoingSettings().getRetryAfter());
			campaignOutgoingSettings.setTrunkName(ncr.getCampaignOutgoingSettings().getTrunkName());
			campaignOutgoingSettings.setPrefix(ncr.getCampaignOutgoingSettings().getPrefix());
			campaignOutgoingSettings.setDialOutWaitTimeInSecs(ncr.getCampaignOutgoingSettings().getDialOutWaitTimeInSecs());
		}
		campaign.setCreatedBy(userId);
		return campaign;
	}

	private static List<ShowField> copyShowFields(
			List<com.phonebridge.portalservice.rest.v1.row.campaign.ShowField> reqShowFields) {
		if(reqShowFields==null || reqShowFields.isEmpty()) {
			return Collections.emptyList();
		}
		List<ShowField> resultShowFields = new ArrayList<>(reqShowFields.size());
		reqShowFields.forEach(reqSf -> {
			ShowField sf = new ShowField();
			sf.setShowFieldID(UUID.randomUUID().toString());
			sf.setFieldLabel(reqSf.getFieldLabel());
			sf.setDisplayField(reqSf.getDisplayField());
			sf.setUrl(reqSf.getIsUrl());
			resultShowFields.add(sf);
		});
		return resultShowFields;
	}

	private static List<Disposition> copyDispositions(
			List<com.phonebridge.portalservice.rest.v1.row.campaign.Disposition> reqDispositions) {
		if(reqDispositions==null || reqDispositions.isEmpty()) {
			return Collections.emptyList();
		}
		List<Disposition> resultDispositions = new ArrayList<>(reqDispositions.size());
		reqDispositions.forEach(reqDis -> {
			Disposition disp = new Disposition();
			disp.setDispositionID(UUID.randomUUID().toString());
			disp.setFieldDataType(EnumDispositionDataType.valueOf(reqDis.getFieldDataType()));
			disp.setFieldLabel(reqDis.getFieldLabel());
			disp.setCallWorkFlow(reqDis.getCallWorkFlow());
			disp.setSendSMS(reqDis.getSendSMS());
			disp.setSmsText(reqDis.getSmsText());
			disp.setConversion(reqDis.getConversion());
			disp.setDropDownValues(reqDis.getDropDownValues());
			//Reccursion
			disp.setDependantDisp(copyDispositions(reqDis.getDependantLst()));
			resultDispositions.add(disp);
		});
		return resultDispositions;
	}


	public static Map<String, String> validateSaveCampaign(NewCampaignRq newCampaignRq) {
		//Need to implement
		return Collections.emptyMap();
	}
}
