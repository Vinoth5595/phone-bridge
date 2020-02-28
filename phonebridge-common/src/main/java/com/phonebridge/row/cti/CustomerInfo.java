package com.phonebridge.row.cti;

import com.phonebridge.row.BasePojo;

import lombok.Data;

@Data
public class CustomerInfo extends BasePojo{
	private String customerID;
	private String customerType;
	private String customerName;
	private String address;
	private String phone1;
	private String phone2;
	private String phone3;
	private String newClientURL;
	private String existingClientURL;
	private String bloodgrp;
	private String age;
	private String gender;
	private String locality;
	private String email;

}