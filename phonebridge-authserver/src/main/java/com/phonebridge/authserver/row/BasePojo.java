package com.phonebridge.authserver.row;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasePojo {
	String createdBy;
	LocalDate createdOn;
	String modifiedBy;
	LocalDate modifiedOn;
}
