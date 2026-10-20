package com.sandeep.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.entities.Students;
import com.sandeep.repo.StudentRepo;
import com.sandeep.service.StudentService;

@Service
public class StudentServiceImpl  implements StudentService{

	@Autowired
	private StudentRepo repo;
	
	@Override
	public Students saveuser(Students stu) {
		Students student=repo.save(stu);
		return student;
	}
	
	

}
