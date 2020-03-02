package com.phonebridge.usermanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	@Id
	private String id;
	private String userId;
	private String password;
//	private String accountId;
//	private String privilege;
//	private Date createdOn;
//	private String createdBy;
//	private Date modifiedOn;
//	private String modifiedBy;
}
