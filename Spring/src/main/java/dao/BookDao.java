package dao;

/*
 * Dao层，接口层，只做sql语句和数据库连接处理
 */

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Book;

@Repository  //@Repository只能标注在DAO类上，作用是是将类识别为Bean、将所标注的类中抛出的数据访问异常封装为Spring的数据访问异常类型
public interface BookDao {

	@Select("select book.*,type.name typename from book inner join type on type.id=book.typeid ${where} ${limit}")  //？
		public List<Book> select(@Param("where") String where,@Param("limit") String limit);  //？
	@Select("select count(1) from book inner join type on type.id=book.typeid ${where}")  //？
	public int selectcount(@Param("where") String where);  //selectcount:分页
	@Insert("insert into book(name,sex,typeid) values(#{name},#{sex},#{typeid})")
		public void insert(Book t);
	@Delete("delete from book where id=#{id}")
	    public void delete(int id);  
	@Update("update book set name=#{name},sex=#{sex},typeid=#{typeid} where id=#{id}")
	    public void update(Book t);
}
