package com.phonebridge.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.phonebridge.usermanagement.mapper.UserMapper;

/**
* Phone Bridge Service 
*
* @author  Vinoth Manoharan
* @version 1.0
* @since   06-March-2020 
*/

@SpringBootApplication
public class PhonebridgeUsermanagementApplication {

	/**
	 * Phone bridge main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(PhonebridgeUsermanagementApplication.class, args);
	}

}
