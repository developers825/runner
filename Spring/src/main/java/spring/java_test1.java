package spring;

import org.junit.Test;

public class java_test1 {
	@Test
	public void aa() {
		String aa="asa.ddd";
		int pos=aa.lastIndexOf(".");
		aa=aa.substring(pos,aa.length()-1);
		System.out.println(aa);
	}
}
