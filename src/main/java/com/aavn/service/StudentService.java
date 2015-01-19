package com.aavn.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aavn.daoi.*;
import com.aavn.domain.*;
import com.aavn.servicei.*;

@Service
@Transactional
public class StudentService implements IStudentService {
	@Autowired
	IStudentDAO studentDAO;
	
	@Override
	public List<Student> getAllStudents() {
		return studentDAO.getAll();
		
	}
	
	@Override
	public void addStudent(Student student){
		 studentDAO.add(student);
	}
}
