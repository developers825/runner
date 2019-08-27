package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@Lazy(true)
public class cnf {
	@Bean
	public Type transferService() {
		System.out.println("云端");
		return new Type(2,"33333");
		
	}
	
}
