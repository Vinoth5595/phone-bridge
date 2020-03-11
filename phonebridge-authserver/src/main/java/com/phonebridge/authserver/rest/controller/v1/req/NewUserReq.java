package com.phonebridge.authserver.rest.controller.v1.req;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

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
public class NewUserReq {

	// account id
	@JsonProperty("accountId")
	private String accountId;

	// account name
	@JsonProperty("userName")
	private String userName;

	// password
	@Size(message = "password size should be between 3 and 20", min = 3, max = 20)
	@JsonProperty("password")
	private String password;

	// privilege
	@JsonProperty("grantedAuthorities")
	@Valid
	private List<String> grantedAuthorities;

}
