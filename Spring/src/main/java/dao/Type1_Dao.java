package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import spring.Type;



	@Repository
	public interface Type1_Dao {
	   public List<Type> selectfor();
	   
	    public Type selectById(int id);
	    
		public int insert(Type b);
		
		public void delete(int id);
		
	}
