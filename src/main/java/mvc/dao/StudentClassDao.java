package mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mvc.entity.StudentClass;

@Repository("studentClassDao")
public class StudentClassDao extends BasicDao<StudentClass> {
	public List<StudentClass> listByUsername(String name) {
		String hql = "select sc from StudentClass sc where sc.name=?";
		return this.list(hql, new Object[] { name });
	}
}
