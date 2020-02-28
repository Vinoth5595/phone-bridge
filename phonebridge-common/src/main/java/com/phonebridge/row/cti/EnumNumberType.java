package com.phonebridge.row.cti;

import java.util.HashMap;
import java.util.Map;

public enum EnumNumberType {
	QUEUE("QUEUE"),PHONENUMBER("PHONENUMBER"),EXTENSION("EXTENSION"),NA("NA");
	
private String NumberTypeStr;
	
	private String getNumberTypeStr() {
		return NumberTypeStr;
	}

	EnumNumberType(String NumberTypeStr) {
		this.NumberTypeStr=NumberTypeStr;
	}
	
	 private static final Map<String, EnumNumberType> lookup = new HashMap<>();
	  
    //Populate the lookup table on loading time
    static
    {
        for(EnumNumberType eachAssStatus : EnumNumberType.values())
        {
            lookup.put(eachAssStatus.getNumberTypeStr(), eachAssStatus);
        }
    }
	
	
	public static EnumNumberType getNumberType(String input) {
		return (lookup.get(input)!=null?lookup.get(input):NA);
	}
}
