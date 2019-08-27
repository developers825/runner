package service.Impl;
//bll层的具体实现，引用Dao层，调用bll层方法做具体实现


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BookDao;
import model.Book;
import service.BookService;
import utils.ReturnInfo;

@Service  //如果一个类带了@Service注解，将自动注册到Spring容器
public class BookService_Impl implements BookService{  //非接口
	@Autowired  //自动装配，其作用是为了消除代码Java代码里面的getter/setter与bean属性中的property。当然，getter看个人需求，如果私有属性需要对外提供的话，应当予以保留
	BookDao dao;
	
	public ReturnInfo select(String where,Integer page,Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where));
		  return info;
	}

	public Book selectByid(int id) {
		// TODO Auto-generated method stub
		return  (Book) dao.select(" where book.id="+id," limit 1").get(0);
	}

	public void insert(Book t) {
		// TODO Auto-generated method stub
		dao.insert(t);
	}

	public void update(Book t) {
		// TODO Auto-generated method stub
		dao.update(t);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

}
