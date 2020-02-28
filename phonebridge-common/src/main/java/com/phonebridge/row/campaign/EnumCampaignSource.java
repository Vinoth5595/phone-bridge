package com.phonebridge.row.campaign;

public enum EnumCampaignSource {
	WithExcelBase("With Excel Base"),ModuleLinked("Module Linked"),PopupInCRM("Popup In CRM"),APICampaign("API Campaign");
	
	private final String CampSource;
	
	EnumCampaignSource(String CampSource) {
		this.CampSource = CampSource;
	}
	
	public String getCampSource() {
		return CampSource;
	}
}
