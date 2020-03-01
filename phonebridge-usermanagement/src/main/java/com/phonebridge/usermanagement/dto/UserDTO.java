package com.phonebridge.usermanagement.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
	private String userId;
	private String password;
//	private String accountId;
//	private String privilege;
//	private Date createdOn;
//	private String createdBy;
//	private Date modifiedOn;
//	private String modifiedBy;
}
