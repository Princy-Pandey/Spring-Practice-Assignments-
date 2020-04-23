package com.cg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.dao.StudentDaoI;
import com.cg.entity.Student;

@SpringBootApplication
public class SpringBootProjectDataJpaRestApplication implements CommandLineRunner{

	@Autowired
	StudentDaoI studao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectDataJpaRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		  Student s1 = new Student(1, "sachin", "cs");
		  Student s2 = new Student(2,"ravi","mech");
		  Student s3 = new Student(3, "santhosh", "cs");
		  Student s4 = new Student(4,"mahesh","civil");
		  
		  studao.create(s1); 
		  studao.create(s2); 
		  studao.create(s3);
		  studao.create(s4);
		  
		  System.out.println("record inserted");
		  studao.delete(3);
		  List<Student> studentlist =studao.reterive();
		  
		  for(Student stu:studentlist) { System.out.println(stu.getId() +" "+
		  stu.getName() +" "+ stu.getDept() ); }
		 
		
		  Student stu=studao.findById(2); System.out.println(stu.getId() +" "+
		  stu.getName() + stu.getDept());
		 
		
		//studao.delete(3);
		
		//studao.update(4);
		
	}

	

}
