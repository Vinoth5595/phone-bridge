package com.phonebridge.authserver.db.mongo.v1.row;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Data
@Document(collection="user")
@EnableMongoAuditing
public class DBRowUser extends BaseDBRow{
	
	@Id
	@MongoId
	private String id;
	
	private String accountId;
	
	private String accountName;

	private String userName;

	private List<String> grantedAuthorities;
	
	private String password;
	
	private Boolean isLocked;
	
	private Boolean isDeleted;
}
