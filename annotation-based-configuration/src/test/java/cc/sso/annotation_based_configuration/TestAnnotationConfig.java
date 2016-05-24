package cc.sso.annotation_based_configuration;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cc.sso.annotation_based_configuration.AccountService;

public class TestAnnotationConfig {
	
	@Test
	public void testConfig(){
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("/cc/sso/annotation_based_configuration/bean-config.xml");
		
		AccountService accountService = 
				applicationContext.getBean("accountServiceImpl", AccountService.class);

		System.out.println("Before money transfer");
		System.out.println("Account (1) balance :" + accountService.getAccount(1).getBalance());
		System.out.println("Account (2) balance :" + accountService.getAccount(2).getBalance());		
		
		accountService.transferMoney(1, 2, 5.0);
		
		System.out.println("After money transfer");
		System.out.println("Account 1 balance :" + accountService.getAccount(1).getBalance());
		System.out.println("Account 2 balance :" + accountService.getAccount(2).getBalance());
	}
	
}
