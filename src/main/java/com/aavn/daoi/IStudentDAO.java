package com.aavn.daoi;
import java.util.List;

import com.aavn.domain.*;

public interface IStudentDAO {
	public void add(Student student);
//	public void update(Student student);
//	public void delete(Student student);
//	public Student get(int id);
	public List<Student> getAll();
}

