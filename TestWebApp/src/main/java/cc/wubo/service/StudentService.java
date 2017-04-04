package cc.wubo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.wubo.dao.StudentDao;
import cc.wubo.po.Student;
@Service
public class StudentService {
	
	@Autowired
	StudentDao studentDao;
	public List<Student> selectByScore(){
		
		System.out.println(11111);
		return 	studentDao.selectByScore();
	}
	public List<Student> findAll(){
		
		return 	studentDao.findAll();
	}

}
