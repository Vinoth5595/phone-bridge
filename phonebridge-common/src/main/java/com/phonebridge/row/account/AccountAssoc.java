package com.phonebridge.row.account;

import com.phonebridge.row.BasePojo;

import lombok.Data;

@Data
public class AccountAssoc extends BasePojo{
	Account parentAccount;
	Account childAccount;
	boolean isActive;
	//Extra Settings
}
