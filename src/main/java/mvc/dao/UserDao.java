package mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mvc.entity.User;

@Repository("userDao")
public class UserDao extends BasicDao<User> {
	public List<User> listByUsername(String username) {
		String hql = "select u from User u where u.username=?";
		return this.list(hql, new Object[] { username });
	}
}
