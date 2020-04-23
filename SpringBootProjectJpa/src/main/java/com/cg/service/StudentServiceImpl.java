package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.StudentDaoI;
import com.cg.entity.Student;

@Service
public class StudentServiceImpl implements StudentServiceI {

@Autowired
StudentDaoI stdDao;

@Override
public Student findById(int id) {
	  
	return stdDao.findById(id);
}
}
