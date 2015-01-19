package com.aavn.servicei;
import java.util.List;
import com.aavn.domain.*;;

public interface IStudentService {
	
	public List<Student> getAllStudents();
	public void addStudent(Student student);
}
