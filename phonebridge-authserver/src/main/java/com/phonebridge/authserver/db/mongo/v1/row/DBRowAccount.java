package com.phonebridge.authserver.db.mongo.v1.row;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Data
@EnableMongoAuditing
@Document("accounts")
public class DBRowAccount extends BaseDBRow{

	//account id
	@Id
	
	@MongoId
	private String id;

	@Field(name="accountName")
	private String accountName;
	
	private Boolean isLocked;
	
	private Boolean isDeleted;
	
	private String parentAccountId;
}
