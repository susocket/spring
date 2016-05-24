package cc.sso.java_based_autowiring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestJavaBasedAutowiring {
	@Test
	public void testConfig(){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(JavaBasedAutowiringConfig.class);
		
		AccountService accountService = 
				applicationContext.getBean("accountService", AccountService.class);

		System.out.println("Before money transfer");
		System.out.println("Account 1 balance :" + accountService.getAccount(1).getBalance());
		System.out.println("Account 2 balance :" + accountService.getAccount(2).getBalance());		
		
		accountService.transferMoney(1, 2, 5.0);
		
		System.out.println("After money transfer");
		System.out.println("Account 1 balance :" + accountService.getAccount(1).getBalance());
		System.out.println("Account 2 balance :" + accountService.getAccount(2).getBalance());
	}
}
