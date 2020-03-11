package com.phonebridge.authserver.row;

import lombok.Data;

@Data
public class AccountRow extends BasePojo{
	
	private String id;
	
	private String accountName;
	
	private Boolean isLocked;
	
	private Boolean isDeleted;
	
	private String parentAccountId;
}
