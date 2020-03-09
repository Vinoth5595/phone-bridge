package com.phonebridge.usermanagement.model;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Phone Bridge user entity
 *
 * @author Vinoth Manoharan
 * @version 1.0
 * @since 06-March-2020
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("users")
public class User {
	// user id
	@Id
	@Field(name = "userId")
	private String userId;

	// account id
	@Field(name = "accountId")
	private ObjectId accountId;

	// account name
	@JsonProperty("userName")
	private String userName;

	// password
	@Field(name = "password")
	private String password;

	// privilege
	@Field(name = "privilege")
	private List<Privilege> privilege;

	// created on
	@Field(name = "createdOn")
	private LocalDateTime createdOn;

	// created by
	@Field(name = "createdBy")
	private String createdBy;

	// modified on
	@Field(name = "modifiedOn")
	private LocalDateTime modifiedOn;

	// modified by
	@Field(name = "modifiedBy")
	private String modifiedBy;

}
