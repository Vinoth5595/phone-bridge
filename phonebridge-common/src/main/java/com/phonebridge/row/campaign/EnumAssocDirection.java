package com.phonebridge.row.campaign;

import java.util.HashMap;
import java.util.Map;

public enum EnumAssocDirection {
	INCOMING("INCOMING"),OUTGOING("OUTGOING"),NA("NA");
	
private String AssocDirectionStr;
	
	private String getAssocDirectionStr() {
		return AssocDirectionStr;
	}

	EnumAssocDirection(String AssocDirectionStr) {
		this.AssocDirectionStr=AssocDirectionStr;
	}
	
	 private static final Map<String, EnumAssocDirection> lookup = new HashMap<>();
	  
    //Populate the lookup table on loading time
    static
    {
        for(EnumAssocDirection eachAssStatus : EnumAssocDirection.values())
        {
            lookup.put(eachAssStatus.getAssocDirectionStr(), eachAssStatus);
        }
    }
	
	
	public static EnumAssocDirection getAssocDirection(String input) {
		return (lookup.get(input)!=null?lookup.get(input):NA);
	}
}
