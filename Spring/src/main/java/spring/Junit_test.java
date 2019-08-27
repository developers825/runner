package spring;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.Type1_Dao;

@RunWith(SpringJUnit4ClassRunner.class)  //在Junit内直接启动Spring容器
@ContextConfiguration(locations= {"classpath:applicationContext-dao.xml"})
public class Junit_test {
	
	@Autowired
	Type1_Dao t;
	@Test  //单元测试
	public void ee() {
		List<spring.Type> list=t.selectfor();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getId()+" "+list.get(i).getName());
		}
	}
}
