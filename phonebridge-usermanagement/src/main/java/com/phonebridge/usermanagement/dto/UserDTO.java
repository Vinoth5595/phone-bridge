package com.phonebridge.usermanagement.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonRootName("user")
public class UserDTO {
	@JsonProperty("id")
	private String id;
	@JsonProperty("userId")
	private String userId;
	@JsonProperty("password")
	private String password;
//	private String accountId;
//	private String privilege;
//	private Date createdOn;
//	private String createdBy;
//	private Date modifiedOn;
//	private String modifiedBy;
}
