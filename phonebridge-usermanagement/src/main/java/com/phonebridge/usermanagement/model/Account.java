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
@Document("accounts")
public class Account {
	// pb id
	@Id
	private String pbId;

	// account id
	private int accountId;

	// account id
	private String accountName;

	// created on
	private LocalDateTime createdOn;

	// created by
	private String createdBy;

	// modified on
	private LocalDateTime modifiedOn;

	// modified by
	private String modifiedBy;
}
