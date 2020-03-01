package com.phonebridge.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.phonebridge.usermanagement.mapper.UserMapper;

@SpringBootApplication
public class PhonebridgeUsermanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhonebridgeUsermanagementApplication.class, args);
	}

}
