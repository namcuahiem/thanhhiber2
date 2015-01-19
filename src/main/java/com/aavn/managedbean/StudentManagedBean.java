package com.aavn.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.aavn.domain.*;
import com.aavn.servicei.*;

@Component("studentMB")
@Scope("session")
public class StudentManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	IStudentService studentService;

	boolean edit = false;
	boolean show = true;
	String msg = "";

	private String name;
	private String imgstring;

	private List<Student> studentList = new ArrayList<>();

	public List<Student> getstudentList() {
		studentList = new ArrayList<Student>();
		if (studentService.getAllStudents() != null)
			studentList.addAll(studentService.getAllStudents());
		return studentList;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getImgstring() {
		return imgstring;
	}

	public void setImgstring(String imgstring) {
		this.imgstring = imgstring;
	}


	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public void addstudent() {
			System.out.println("ok");
			Student student = new Student();
			
			student.setName(name);
			student.setImg(imgstring);
			studentService.addStudent(student);
			this.msg = "Add successfully!";
	}

	public void canedit(){
		edit = true;
		show = false;
	}
	
	public void disableedit(){
		edit = false;
		show = true;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public void check() {
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("welcome.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

