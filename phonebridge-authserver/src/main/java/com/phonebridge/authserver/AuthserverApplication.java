package com.phonebridge.authserver;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.phonebridge.authserver.db.mongo.v1.repository.AccountRepository;
import com.phonebridge.authserver.db.mongo.v1.row.DBRowAccount;

@SpringBootApplication
public class AuthserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthserverApplication.class, args);
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
			// repository.save(
//					Account.builder().accountId("123").accountName("Vinz Corporation").createdOn(LocalDateTime.now())
//							.createdBy("SYSTEM").modifiedOn(LocalDateTime.now()).modifiedBy("SYSTEM").build());
			DBRowAccount dbRowAccount = new DBRowAccount();
			dbRowAccount.setIsDeleted(false);
			dbRowAccount.setIsLocked(false);
			dbRowAccount.setAccountName("vinz_technologies");
			dbRowAccount.setParentAccountId("124");
			repository.save(dbRowAccount);
		}
	}

}
