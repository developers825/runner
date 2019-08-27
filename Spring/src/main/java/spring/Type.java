package spring;

import javax.annotation.PostConstruct;

public class Type implements TypeInterface{  //类的继承相当于多命名
	private int id;
	private String name;
	public Type() {
		
	}
	
	public Type(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@PostConstruct
	public void init() {
		System.out.println("你是不是傻");
	}
	public Type(String name) {
		super();
		this.id=id;
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
//		int a=Integer.valueOf("s");
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
