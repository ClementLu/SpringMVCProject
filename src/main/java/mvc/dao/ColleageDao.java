package mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mvc.entity.Colleage;

@Repository("colleageDao")
public class ColleageDao extends BasicDao<Colleage> {
	public List<Colleage> listByUsername(String name) {
		String hql = "select c from Colleage c where c.name=?";
		return this.list(hql, new Object[] { name });
	}
}
