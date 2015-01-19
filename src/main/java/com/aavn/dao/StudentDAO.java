package com.aavn.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.aavn.daoi.*;
import com.aavn.domain.*;


@SuppressWarnings("unchecked")
@Repository
public class StudentDAO implements IStudentDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Student> getAll(){
		try {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(
					Student.class);
			crit.setCacheable(true);
			return crit.list();
		} catch (HibernateException exception) {
			return null;
		}
	}
	
	@Override
	public void add(Student student){
		sessionFactory.getCurrentSession().save(student);;
	}
	

}
