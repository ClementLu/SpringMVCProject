package mvc.service;

import java.util.List;
import java.util.ListIterator;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mvc.dao.UserDao;
import mvc.entity.User;
import mvc.entity.UserException;

@Service(value = "userService")
public class UserService {
	@Resource(name = "userDao")
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void addNewUser(User newUser) throws UserException {
		List<User> users = userDao.listByUsername(newUser.getUsername());
		if (users != null && users.size() > 0)
			throw new UserException("用户已存在");
		userDao.save(newUser);
	}

	public User findByUsernameAndPassword(String username, String password) throws UserException {
		List<User> result = userDao.listByUsername(username);
		ListIterator<User> it = result.listIterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		if (result == null && result.size() > 0) {
			throw new UserException("用户名不存在");
		} else {
			if (!password.equals(result.get(0).getPassword())) {
				throw new UserException("密码错误");
			}
		}
		return result.get(0);
	}
}