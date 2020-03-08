package com.phonebridge.usermanagement;

import java.time.LocalDateTime;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.phonebridge.usermanagement.model.Account;
import com.phonebridge.usermanagement.model.Privilege;
import com.phonebridge.usermanagement.model.User;
import com.phonebridge.usermanagement.repository.AccountRepository;
import com.phonebridge.usermanagement.repository.UserRepository;

/**
 * Phone Bridge Service
 *
 * @author Vinoth Manoharan
 * @version 1.0
 * @since 06-March-2020
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

	/**
	 * To load user data on application startup
	 * 
	 * @param repository
	 * @return
	 */
	@Bean
	ApplicationRunner initUserData(UserRepository repository) {
		return (ApplicationArguments args) -> loadInitialUserData(repository);
	}

	/**
	 * To load account data on application startup
	 * 
	 * @param repository
	 * @return
	 */
	@Bean
	ApplicationRunner initAccountData(AccountRepository repository) {
		return (ApplicationArguments args) -> loadInitialAccountData(repository);
	}

	/**
	 * To load super admin
	 * 
	 * @param repository
	 */
	public void loadInitialAccountData(AccountRepository repository) {
		if (repository.count() <= 0) {
			repository.save(
					Account.builder().accountId(10000).accountName("Vinz Corporation").createdOn(LocalDateTime.now())
							.createdBy("SYSTEM").modifiedOn(LocalDateTime.now()).modifiedBy("SYSTEM").build());
			repository.save(
					Account.builder().accountId(10001).accountName("Sonu Corporation").createdOn(LocalDateTime.now())
							.createdBy("SYSTEM").modifiedOn(LocalDateTime.now()).modifiedBy("SYSTEM").build());
		}
	}

	/**
	 * To load account data
	 * 
	 * @param repository
	 */
	public void loadInitialUserData(UserRepository repository) {
		if (repository.count() <= 0)
			repository.save(User.builder().accountId(10000).userId("pbsuperuser").password("password")
					.privilege(Privilege.SUPER_ADMIN).createdBy("SYSTEM").createdOn(LocalDateTime.now())
					.modifiedOn(LocalDateTime.now()).modifiedBy("SYSTEM").build());
	}
}
