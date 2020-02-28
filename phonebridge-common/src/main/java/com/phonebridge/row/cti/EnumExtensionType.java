package com.phonebridge.row.cti;

import java.util.HashMap;
import java.util.Map;

public enum EnumExtensionType {
	SIP("SIP"),VOIP("VOIP"),IAX("IAX"),PHONENUMBER("PHONENUMBER"),NA("NA");
	
	private String ExtensionTypeStr;
	
	private String getExtensionTypeStr() {
		return ExtensionTypeStr;
	}

	EnumExtensionType(String ExtensionTypeStr) {
		this.ExtensionTypeStr=ExtensionTypeStr;
	}
	
	 private static final Map<String, EnumExtensionType> lookup = new HashMap<>();
	  
    //Populate the lookup table on loading time
    static
    {
        for(EnumExtensionType eachAssStatus : EnumExtensionType.values())
        {
            lookup.put(eachAssStatus.getExtensionTypeStr(), eachAssStatus);
        }
    }
	
	
	public static EnumExtensionType getExtensionType(String input) {
		return (lookup.get(input)!=null?lookup.get(input):NA);
	}
}
