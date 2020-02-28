package com.phonebridge.row.cti;

import java.util.Date;

import com.phonebridge.row.BasePojo;
import com.phonebridge.row.campaign.EnumAssocDirection;

import lombok.Data;

@Data
public class UpdateCallInfo extends BasePojo{
	private String accountId;
	private String serverId;
	private EnumExtensionType extensionType;
	private String extensionNo;
	private String callId;
	private String extenChannel;
	private EnumAssocStatus assocStatus;
	private String prefix;
	private String phoneNumber;
	private EnumNumberType numberType;
	private String displayNumber;
    private EnumAssocDirection assocDirection;
    private String assocChannel;
    private Date statusStart;
    private Date statusEnd;
    private EnumAssocEndedBy assocEndedBy; 
}