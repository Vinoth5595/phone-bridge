package com.phonebridge.usermanagement.model;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
@Document("accounts")
public class Account {

	// account id
	@Id
	@Field(name="accountId")
	private ObjectId accountId;

	// account name
	@Field(name="accountName")
	private String accountName;

	// created on
	@Field(name="createdOn")
	private LocalDateTime createdOn;

	// created by
	@Field(name="createdBy")
	private String createdBy;

	// modified on
	@Field(name="modifiedOn")
	private LocalDateTime modifiedOn;

	// modified by
	@Field(name="modifiedBy")
	private String modifiedBy;
}
