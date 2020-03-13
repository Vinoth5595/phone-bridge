package com.phonebridge.portalservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RefreshScope
@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneBridgePropertyConfig {

	@Value("${maximum}")
	private String maximum;
}
