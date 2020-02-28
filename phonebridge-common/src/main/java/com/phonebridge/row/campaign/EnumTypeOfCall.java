package com.phonebridge.row.campaign;

import java.util.HashMap;
import java.util.Map;

public enum EnumTypeOfCall {
	QUEUE_INCOMING("QUEUE_INCOMING"),EXTENSION_INCOMING("EXTENSION_INCOMING"),PROGRESSIVE_OUTGOING("PROGRESSIVE_OUTGOING")
	,MANUAL_OUTGOING("MANUAL_OUTGOING"),PREDICTIVE_OUTGOING("PREDICTIVE_OUTGOING"),MISSED_CALL("MISSED_CALL")
	,MISSED_CALL_CALLBACK("MISSED_CALL_CALLBACK"),NA("NA");
	
private String TypeOfCallStr;
	
	private String getTypeOfCallStr() {
		return TypeOfCallStr;
	}

	EnumTypeOfCall(String TypeOfCallStr) {
		this.TypeOfCallStr=TypeOfCallStr;
	}
	
	 private static final Map<String, EnumTypeOfCall> lookup = new HashMap<>();
	  
    //Populate the lookup table on loading time
    static
    {
        for(EnumTypeOfCall eachAssStatus : EnumTypeOfCall.values())
        {
            lookup.put(eachAssStatus.getTypeOfCallStr(), eachAssStatus);
        }
    }
	
	
	public static EnumTypeOfCall getTypeOfCall(String input) {
		return (lookup.get(input)!=null?lookup.get(input):NA);
	}
}
