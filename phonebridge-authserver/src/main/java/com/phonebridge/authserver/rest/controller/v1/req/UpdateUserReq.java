package com.phonebridge.authserver.rest.controller.v1.req;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
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
@JsonRootName("user")
public class UpdateUserReq {

	private String id;
	
	// account id
	@JsonProperty("accountId")
	private String accountId;

	// account name
	@JsonProperty("userName")
	private String userName;

	// privilege
	@JsonProperty("grantedAuthorities")
	@Valid
	private List<String> grantedAuthorities;

}
