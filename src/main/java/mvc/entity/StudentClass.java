package mvc.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "t_studentclass")
public class StudentClass {
	@Id
	@GeneratedValue
	private int id;

	@Column(unique = true)
	private String name;

	@OneToMany(mappedBy = "studentClass", cascade = (CascadeType.ALL), fetch = FetchType.EAGER)
	private Set<Student> students;

	@ManyToOne(fetch = FetchType.LAZY, cascade = (CascadeType.ALL)) // 延迟加载方式加载对象
	@JoinColumn(name = "academy_id")
	private Academy academy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public StudentClass(int id, String name, Set<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.students = students;
	}

}
