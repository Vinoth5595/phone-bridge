package com.phonebridge.authserver.db.mongo.v1.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.phonebridge.authserver.db.mongo.v1.row.DBRowUser;
import com.phonebridge.authserver.row.UserRow;

public class DBUserUtils {

	public static UserRow convertDBRowUserToUser(DBRowUser dbRowUser) {
		return Optional.ofNullable(dbRowUser)
				.map(inDbRowUser -> {
					UserRow userRow=new UserRow();
					BeanUtils.copyProperties(inDbRowUser, userRow);
					return userRow;
					}
				)
				.orElse(null);
	}
	
}
