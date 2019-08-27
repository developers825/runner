package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Type;
import service.TypeService;
import utils.ReturnInfo;

@Controller
@RequestMapping("Type")
public class TypeController {
	@Autowired
	TypeService tservice;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,ModelMap m,Integer limit,Integer page) {
		if (txt != null && txt.length() > 0)
			txt = " where type.name like '%" + txt + "%'";
		else
			txt = " ";
		return tservice.select(txt, page, limit);
	}
	@RequestMapping("edit")
	public @ResponseBody Type edit(int id,ModelMap m) {
		return tservice.selectById(id);
	}
	@RequestMapping("insert")
	public @ResponseBody String insert(Type b,ModelMap m) {
		tservice.insert(b);
		return "{\"status\":1}";
	}
	@RequestMapping("delete")
	public @ResponseBody String delete(int id,ModelMap m) {
		tservice.delete(id);
		return "{\"status\":1}";
		}
	@RequestMapping("update")
	public @ResponseBody String update(Type b,ModelMap m) {
		tservice.update(b);
		return "{\"status\":1}";
		}
}
