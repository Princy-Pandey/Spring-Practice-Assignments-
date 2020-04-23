package com.cg.dao;

import java.util.List;

import com.cg.entity.Student;

public interface StudentDaoI {

	public void create(Student s);

	public List<Student> reterive();

	public Student findById(int id);

	public void delete(int id);

	public void update(int id);

}
