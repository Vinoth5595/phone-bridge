package com.phonebridge.authserver.rest.controller.v1.resp;

import java.util.List;

import lombok.Data;

@Data
public class UserResp {

	private String id;
	
	private String accountId;
	
	private String accountName;

	private String userName;

	private List<String> grantedAuthorities;

}
