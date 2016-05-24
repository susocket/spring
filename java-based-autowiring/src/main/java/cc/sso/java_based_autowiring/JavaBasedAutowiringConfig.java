package cc.sso.java_based_autowiring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaBasedAutowiringConfig {

	@Bean
	public AccountService accountService(){
		AccountServiceImpl bean = new AccountServiceImpl();
		return bean;
	}
	
	@Bean
	@Qualifier
	public AccountDao accountDaoInMemoryImpl(){
		AccountDaoInMemoryImpl bean = new AccountDaoInMemoryImpl();
		return bean;
	}
	
	@Bean
	public AccountDao accountDaoJdbcImpl(){
		AccountDaoJdbcImpl bean = new AccountDaoJdbcImpl();
		return bean;
	}
}
