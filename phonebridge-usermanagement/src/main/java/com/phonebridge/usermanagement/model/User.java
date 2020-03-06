package com.phonebridge.usermanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Phone Bridge user entity 
*
* @author  Vinoth Manoharan
* @version 1.0
* @since   06-March-2020 
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("users")
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
