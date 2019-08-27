package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TypeDao;
import model.Type;
import service.TypeService;
import utils.ReturnInfo;

@Service
public class TypeService_Impl implements TypeService{
	@Autowired
	TypeDao tdao;

	public List<Type> selectfor() {
		return tdao.selectfor();
	}

	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(tdao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(tdao.selectcount(where));
		  return info;
	}

	public Type selectById(int id) {
		return tdao.selectById(id);
	}

	public void insert(Type b) {
		tdao.insert(b);
	}

	public void update(Type b) {
	    tdao.update(b);
	}

	public void delete(int id) {
		tdao.delete(id);
	}

}
