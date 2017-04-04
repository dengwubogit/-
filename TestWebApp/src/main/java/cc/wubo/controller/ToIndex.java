package cc.wubo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.wubo.po.Student;
import cc.wubo.service.StudentService;

@Controller
public class ToIndex {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("toIndex")
	public String toIndex(){
		 
		return "index";
	}
	@RequestMapping("selectByScore")
	@ResponseBody
	public List<Student> selectByScore(){
		System.out.println(studentService);
		List<Student> selectByScore = studentService.selectByScore();
		
		return selectByScore;
	}
	@RequestMapping("findAll")
	@ResponseBody
	public List<Student> findAll(){
		System.out.println(studentService);
		List<Student> findAll = studentService.findAll();
		System.out.println(findAll);
		return findAll;
	}

}
