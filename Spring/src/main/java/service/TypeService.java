package service;

import java.util.List;

import model.Type;
import utils.ReturnInfo;

public interface TypeService {
	
public List<Type> selectfor();
public ReturnInfo select(String where,Integer page,Integer max);
	
	public Type selectById(int id);
	
	public void insert(Type b);
	
	public void update(Type b);
	
	public void delete(int id);
	}
