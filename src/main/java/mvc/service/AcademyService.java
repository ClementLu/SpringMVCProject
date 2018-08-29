package mvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import mvc.dao.AcademyDao;
import mvc.entity.Academy;
import mvc.entity.UserException;

@Service(value = "academyService")
public class AcademyService {
	@Resource(name = "academyDao")
	private AcademyDao academyDao;

	public AcademyDao getAcademyDao() {
		return academyDao;
	}

	public void setAcademyDao(AcademyDao academyDao) {
		this.academyDao = academyDao;
	}

	public void addAcademy(Academy academy) throws UserException {
		List<Academy> result = academyDao.listByUsername(academy.getName());
		if (result != null && result.size() > 0) {
			throw new UserException("此学院已存在");
		}
		academyDao.save(academy);
	}

	public List<Academy> listAllAcademy() {
		return academyDao.list(Academy.class);
	}

	public void deleteAcademy(Academy deleteAcademy) {
		academyDao.delete(deleteAcademy);
	}

	public Academy findById(int id) {
		return academyDao.findById(Academy.class, id);
	}

}
