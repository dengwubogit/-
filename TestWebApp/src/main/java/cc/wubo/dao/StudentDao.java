package cc.wubo.dao;

import java.util.List;

import cc.wubo.po.Student;

public interface StudentDao {
	public List<Student> selectByScore();
	
	public List<Student> findAll();

}
