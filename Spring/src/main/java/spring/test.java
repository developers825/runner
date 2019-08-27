package spring;

import java.io.FileInputStream;
import java.lang.reflect.Field;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class test {
	@Test
	public void t1() throws Exception {
		DocumentBuilderFactory f=DocumentBuilderFactory.newInstance();  //调用 DocumentBuilderFactory.newInstance() 方法得到创建 DOM 解析器的工厂，可以生产DocumentBuilder对象
		DocumentBuilder b=f.newDocumentBuilder();  //可以根据需求去解析已有xml文件（parse）或者创建新的document文件(newDocument)。
		Document d=b.parse(new FileInputStream("F:/applicationContext.xml"));
		
//		System.out.println(d.getFirstChild().getNodeName());  //获取并打印第一个节点
	    
		Node n1=d.getFirstChild();  //根节点（bean）
		NodeList ns=n1.getChildNodes();  //得到所有节点
		for(int i=0;i<ns.getLength();i++) {
			if(ns.item(i).getNodeName().equals("bean")) {
				Element e=(Element) ns.item(i);
				String cname=e.getAttribute("class");  //获取属性
				
				//反射：
				Class<?> cls=Class.forName(cname);
				Object obj=cls.newInstance();  //创建对象
//				System.out.println(obj.getClass());
				
				//获取子节点
				NodeList ns1=e.getChildNodes();
				for(int ii=0;ii<ns1.getLength();ii++) {
					if(ns1.item(ii).getNodeName().equals("property")) {  //如果获取到的名称为property
						Element e1=(Element) ns1.item(ii);
						String name=e1.getAttribute("name");  //拿到节点里的name属性
						String val=e1.getAttribute("value");
						Field f1=cls.getDeclaredField(name);
						f1.setAccessible(true);
						f1.set(obj, val);
						}
				}
				Type o=(Type) obj;
				System.out.println(o.getName());
			}
		}
	}
}
