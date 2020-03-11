package com.phonebridge.authserver.db.mongo.v1.row;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDBRow {

	@CreatedBy
	String createdBy;

	@CreatedDate
	LocalDate createdOn;

	@LastModifiedBy
	String modifiedBy;

	@LastModifiedDate
	LocalDate modifiedOn;

	@Version
	Long version;
}
