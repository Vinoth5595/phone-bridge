package com.phonebridge.usermanagement.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

	// pb id
	@Id
	private String pbId;

	// account id
	private int accountId;

	// user id
	private String userId;

	// password
	private String password;

	// privilege
	private Privilege privilege;

	// created on
	private LocalDateTime createdOn;

	// created by
	private String createdBy;

	// modified on
	private LocalDateTime modifiedOn;

	// modified by
	private String modifiedBy;


}
