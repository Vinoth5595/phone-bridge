package com.phonebridge.portalservice.db.mongo.v1.row;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasePojo {
	ObjectId createdBy;
	LocalDate createdOn;
	ObjectId modifiedBy;
	LocalDate modifiedOn;
}
