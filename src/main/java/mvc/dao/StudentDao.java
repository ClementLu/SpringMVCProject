package mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mvc.entity.Student;

@Repository("studentDao")
public class StudentDao extends BasicDao<Student> {
	public List<Student> listByUsername(String studentName) {
		String hql = "select s from Student s where s.studentName=?";
		return this.list(hql, new Object[] { studentName });
	}
}
