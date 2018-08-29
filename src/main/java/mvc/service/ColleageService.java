package mvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mvc.dao.ColleageDao;
import mvc.entity.Colleage;
import mvc.entity.UserException;

@Service(value = "colleageService")
public class ColleageService {
	@Resource(name = "colleageDao")
	private ColleageDao colleageDao;

	public ColleageDao getColleageDao() {
		return colleageDao;
	}

	public void setColleageDao(ColleageDao colleageDao) {
		this.colleageDao = colleageDao;
	}

	public void addcolleage(Colleage colleage) throws UserException {
		List<Colleage> result = colleageDao.listByUsername(colleage.getName());
		if (result != null && result.size() > 0) {
			throw new UserException("此学校已存在");
		}
		colleageDao.save(colleage);
	}

	// 显示数据库数据
	public List<Colleage> listAllColleage() {
		return colleageDao.list(Colleage.class);// 通过class参数可以得到entityname
	}

	public Colleage findById(int id) {
		return colleageDao.findById(Colleage.class, id);
	}

	public void deleteColleage(Colleage colleage) {
		colleageDao.delete(colleage);
	}
}
