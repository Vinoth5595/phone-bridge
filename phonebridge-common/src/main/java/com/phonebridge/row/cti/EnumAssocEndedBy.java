package com.phonebridge.row.cti;

import java.util.HashMap;
import java.util.Map;

public enum EnumAssocEndedBy {
	ADMIN("ADMIN"),EXTENSION("EXTENSION"),OTHERPARTY("OTHERPARTY"),NA("NA");
	
private String AssocEndedByStr;
	
	private String getAssocEndedByStr() {
		return AssocEndedByStr;
	}

	EnumAssocEndedBy(String AssocEndedByStr) {
		this.AssocEndedByStr=AssocEndedByStr;
	}
	
	 private static final Map<String, EnumAssocEndedBy> lookup = new HashMap<>();
	  
    //Populate the lookup table on loading time
    static
    {
        for(EnumAssocEndedBy eachAssStatus : EnumAssocEndedBy.values())
        {
            lookup.put(eachAssStatus.getAssocEndedByStr(), eachAssStatus);
        }
    }
	
	
	public static EnumAssocEndedBy getAssocEndedBy(String input) {
		return (lookup.get(input)!=null?lookup.get(input):NA);
	}
}
