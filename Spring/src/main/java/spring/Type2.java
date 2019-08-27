package spring;

public class Type2 {
	private int id;
	private String name;
	private Type t;
	public Type2() {
		
	}
	public void init() {
		System.out.println("初始化");
	}
	public Type2(Type t) {
		super();
		this.t=t;
	}
	public Type getT() {
		return t;
	}
	public Type2(int id,String name) {
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
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
