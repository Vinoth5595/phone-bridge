package com.phonebridge.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@SpringBootApplication
public class PhonebridgeAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhonebridgeAdminApplication.class, args);
	}
}
