package com.phonebridge.usermanagement.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.phonebridge.usermanagement.model.Privilege;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Phone Bridge user data transaction object
 *
 * @author Vinoth Manoharan
 * @version 1.0
 * @since 06-March-2020
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonRootName("user")
public class UserDTO {
	// pb id
	@JsonProperty("pbId")
	private String pbId;

	// account id
	@JsonProperty("accountId")
	private int accountId;

	// user id
	@JsonProperty("userId")
	private String userId;

	// password
	@JsonProperty("password")
	private String password;

	// privilege
	@JsonProperty("privilege")
	private Privilege privilege;

	// created on
	@JsonProperty("createdOn")
	private Date createdOn;

	// created by
	@JsonProperty("createdBy")
	private String createdBy;

	// modified on
	@JsonProperty("modifiedOn")
	private Date modifiedOn;

	// modified by
	@JsonProperty("modifiedBy")
	private String modifiedBy;
}
