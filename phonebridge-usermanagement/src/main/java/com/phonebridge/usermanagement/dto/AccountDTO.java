package com.phonebridge.usermanagement.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Phone Bridge account data transaction object
 *
 * @author Vinoth Manoharan
 * @version 1.0
 * @since 08-March-2020
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonRootName("account")
public class AccountDTO {

	// pb id
	@JsonProperty("pbId")
	@JsonIgnore
	private String pbId;

	// account id
	@Min(10000)
	@Max(99999)
	@JsonProperty("accountId")
	private int accountId;

	// account id
	@NotEmpty
	@Size(message="accountName size should be between 3 and 20",min=3,max=50)
	@JsonProperty("accountName")
	private String accountName;

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
