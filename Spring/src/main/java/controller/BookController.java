package controller;
import java.io.File;
import java.io.IOException;
//控制器层
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import service.BookService;
import service.TypeService;
import spring.Book;
import spring.Type;
import utils.ReturnInfo;


@RestController  //加@RestController后下面方法全部自动加@ResponseBody
//@Controller//@Controller 标记一个类是Controller ，然后使用@RequestMapping 和@RequestParam 等一些注解用以定义URL 请求和Controller 方法之间的映射，这样的Controller 就能被外界访问到

@RequestMapping("Book")
//@SessionAttributes(names="user",types=String.class)
public class BookController {
	@Autowired
	BookService service;
	@Autowired
	TypeService tservice;
	
//	@ModelAttribute("all")
//	public int aaas() {
//		System.out.println("ddddddd");
//		return 300;
//	}
//	
//	@GetMapping("sss")
//	public void aaa(int id,ModelMap m) {
//		System.out.println(m.get("all"));
//	}
	
	@RequestMapping("sss")  //@GetMapping是一个组合注解，等价于@RequestMapping(method = RequestMethod.GET)，它将HTTP Get请求映射到特定的处理方法上
	public void aa(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest req) {
//		return "json";           //Object将自动转为json
		String oname=file.getOriginalFilename();
		String ex=oname.substring(oname.lastIndexOf("."),oname.length());
		String nname = UUID.randomUUID()+ex;
		String path=req.getSession().getServletContext().getRealPath("/");
		path=new File(path).getParentFile().getPath()+"/upload";
		try {
			file.transferTo(new File(path,nname));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@ExceptionHandler
//	public void ex(Exception e) {
//		e.printStackTrace();
//	}
//	
//	@RequestMapping("index")
//	public @ResponseBody ReturnInfo index(String txt,ModelMap m,Integer page,Integer limit) {
//		if (txt != null && txt.length() > 0)
//			txt = " where book.name like '%" + txt + "%'";
//		else
//			txt = "";
//		return service.select(txt, page, limit);
//	}
//	@RequestMapping("edit")
//	public @ResponseBody Book edit(int id,ModelMap m) {  //@responseBody注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML
//		return service.selectByid(id);
//	}
//	@RequestMapping("insert")
//	 public @ResponseBody String insert(Book t,ModelMap m) {
//		service.insert(t);
//		return "{\"status\":1}";
//	}
//	@RequestMapping("delete")
//	public @ResponseBody String delete(int id,ModelMap m) {
//		service.delete(id);
//		return "{\"status\":1}";
//	}
//	@RequestMapping("update")
//	public @ResponseBody String update(Book t,ModelMap m) {
//		service.update(t);
//		return "{\"status\":1}";
//	}
//	@RequestMapping("getSexs")
//	public @ResponseBody String[] getSexs(ModelMap m) {
//		return Book.sexs;
//	}
//	@RequestMapping("getTypes")
//	public @ResponseBody List<Type> getTypes(ModelMap m) {
//		return tservice.selectfor();
//	}
}
