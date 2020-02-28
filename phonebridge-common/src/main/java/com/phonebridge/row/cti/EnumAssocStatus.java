package com.phonebridge.row.cti;

import java.util.HashMap;
import java.util.Map;

public enum EnumAssocStatus {
	DIALING("DIALING"),CONNECTED("CONNECTED"),ENDED("ENDED"),NA("NA");
	
	private String assocStatusStr;
	
	private String getAssocStatusStr() {
		return assocStatusStr;
	}

	EnumAssocStatus(String assocStatusStr) {
		this.assocStatusStr=assocStatusStr;
	}
	
	 private static final Map<String, EnumAssocStatus> lookup = new HashMap<>();
	  
    //Populate the lookup table on loading time
    static
    {
        for(EnumAssocStatus eachAssStatus : EnumAssocStatus.values())
        {
            lookup.put(eachAssStatus.getAssocStatusStr(), eachAssStatus);
        }
    }
	
	
	public static EnumAssocStatus getAssocStatus(String input) {
		return (lookup.get(input)!=null?lookup.get(input):NA);
	}
}
