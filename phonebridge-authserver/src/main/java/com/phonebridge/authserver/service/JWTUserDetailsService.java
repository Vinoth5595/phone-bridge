package com.phonebridge.authserver.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.phonebridge.authserver.row.UserRow;

@Service
public class JWTUserDetailsService implements UserDetailsService {

	IUserService userService;
	
	
	public JWTUserDetailsService(@Autowired IUserService userService) {
		this.userService=userService;
	}
	/**
	 * We treat Username to be AccountId::UserName
	 */
	@Override
	public UserDetails loadUserByUsername(String inUsername) throws UsernameNotFoundException {
		if(inUsername==null || !inUsername.contains("::")) {
			throw new UsernameNotFoundException("User not found with username: " + inUsername);
		}
		String[] userNameArr = inUsername.split("::");
		UserRow userRow = userService.getUserByUserNameAndAccountName(userNameArr[1], userNameArr[0]);
		if(userRow==null) {
			throw new UsernameNotFoundException("User not found with username: " + inUsername);
		}
		return new User(userRow.getAccountId()+"::"+userRow.getId(), userRow.getPassword(),
				getGrantedAUthorities(userRow.getGrantedAuthorities()));
	}

	private List<GrantedAuthority> getGrantedAUthorities(List<String> authStrLst){
		return authStrLst.stream()
				.map(m -> new GrantedAuthority() {
						@Override
						public String getAuthority() {
							return "ROLE_"+m;
						}
				})
				.collect(Collectors.toList());
	}
}
