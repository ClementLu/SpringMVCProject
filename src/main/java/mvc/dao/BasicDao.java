package mvc.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class BasicDao<T> {

	@Autowired // 依赖注入，基于类型
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void save(T t) {
		this.hibernateTemplate.save(t);
	}

	public void delete(T t) {
		this.hibernateTemplate.delete(t);
	}

	public void update(T t) {
		this.hibernateTemplate.update(t);
	}

	public T findById(Class<T> entityClass, int id) {
		return this.hibernateTemplate.get(getTClass(), id);
	}

	public T delete(Class<T> entityClass, int id) {
		return this.hibernateTemplate.get(getTClass(), id);
	}

	// 泛型
	public List<T> list(Class<T> entityClass) {
		String hql = "select entity from " + entityClass.getName() + " entity";
		// 注意，这里是给表重命名，要加一个空格，否则会报错
		return this.list(hql, null);
	}

	@SuppressWarnings("unchecked")
	public Class<T> getTClass() {// 获取泛型的类型
		Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		return entityClass;
	}

	@SuppressWarnings("unchecked")
	public List<T> list(String hql, Object... args) {
		Query q = this.hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				q.setParameter(i, args[i]);
			}
		}
		List<T> list = q.list();
		return list;
	}
}
