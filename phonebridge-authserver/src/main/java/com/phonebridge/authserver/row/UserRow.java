package com.phonebridge.authserver.row;

import java.util.List;

import lombok.Data;

@Data
public class UserRow  extends BasePojo{
	private String id;
	private String accountId;
	private String accountName;
	private String userName;
	private String password;
	private List<String> grantedAuthorities;
	private Boolean isLocked;
	private Boolean isDeleted;
}
