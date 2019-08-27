package spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Java_test {

	@Test
	public void aa() {
		ApplicationContext act=new ClassPathXmlApplicationContext("aa.xml");
//		Type2 t=(Type2) act.getBean(Type2.class);
		Type2 t=(Type2) act.getBean("my");
		System.out.println(t.getName());
	}
}
