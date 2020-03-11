package com.phonebridge.authserver.rest.controller.v1.req;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
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
@JsonRootName("account")
public class NewAccountReq {

	@NotEmpty
	@Size(message="accountName size should be between 3 and 20",min=3,max=50)
	@JsonProperty("accountName")
	private String accountName;
	
	private String parentAccountId;
	
}
