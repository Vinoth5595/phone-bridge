package com.phonebridge.usermanagement.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;

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

	// account id
	@JsonProperty("userId")
	private String userId;

	// account id
	@JsonProperty("accountId")
	private ObjectId accountId;

	// account name
	@JsonProperty("userName")
	private String userName;

	// password
	@Size(message = "password size should be between 3 and 20", min = 3, max = 20)
	@JsonProperty("password")
	private String password;

	// privilege
	@JsonProperty("privilege")
	@Valid
	private List<Privilege> privilege;

	// created on
	@JsonProperty("createdOn")
	private LocalDateTime createdOn;

	// created by
	@JsonProperty("createdBy")
	private String createdBy;

	// modified on
	@JsonProperty("modifiedOn")
	private LocalDateTime modifiedOn;

	// modified by
	@JsonProperty("modifiedBy")
	private String modifiedBy;
}
