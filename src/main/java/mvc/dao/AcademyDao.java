package mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mvc.entity.Academy;;

@Repository("academyDao")
public class AcademyDao extends BasicDao<Academy> {
	public List<Academy> listByUsername(String name) {
		String hql = "select a from Academy a where a.name=?";
		return this.list(hql, new Object[] { name });
	}
}
