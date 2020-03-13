package com.phonebridge.portalservice.testing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phonebridge.portalservice.config.PhoneBridgePropertyConfig;

@RefreshScope
@RestController
@RequestMapping("/config")
public class ConfigTestController {
	
	@Autowired
	PhoneBridgePropertyConfig pbPropConfig;

	@GetMapping("/property")
	public String getMessage() {
		return pbPropConfig.getMaximum();
	}
	
}
