package service;
//bll(service)层，处理业务，调用关系(/方法)进行抽象
import model.Book;
import utils.ReturnInfo;

public interface BookService {
	
	public ReturnInfo select(String where,Integer page,Integer max);  //分页，max：最大行
	
	public Book selectByid(int id);
	
	public void insert(Book t);
	
	public void update(Book t);
	public void delete(int id);
}
