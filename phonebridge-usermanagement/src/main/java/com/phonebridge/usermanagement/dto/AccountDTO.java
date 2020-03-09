package com.phonebridge.usermanagement.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	// account id
	@JsonProperty("accountId")
	private ObjectId accountId;

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

//	public String getAccountId() {
//		return accountId.toHexString();
//	}
	
	
}
