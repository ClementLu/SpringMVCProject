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

@Entity
@Table(name = "t_academy")
public class Academy {
	@Id
	@GeneratedValue
	private int id;

	@Column(unique = true)
	private String name;

	@OneToMany(mappedBy = "academy", cascade = (CascadeType.ALL), fetch = FetchType.EAGER)
	private Set<StudentClass> studentClasses;

	@ManyToOne(fetch = FetchType.LAZY, cascade = (CascadeType.ALL))
	private Colleage colleage;

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

	public Set<StudentClass> getStudentClasses() {
		return studentClasses;
	}

	public void setStudentClasses(Set<StudentClass> studentClasses) {
		this.studentClasses = studentClasses;
	}

	public Colleage getColleage() {
		return colleage;
	}

	public void setColleage(Colleage colleage) {
		this.colleage = colleage;
	}

	public Academy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Academy(String name, Set<StudentClass> studentClasses) {
		super();
		this.name = name;
		this.studentClasses = studentClasses;
	}

	@Override
	public String toString() {
		return "Academy [id=" + id + ", name=" + name + ", studentClasses=" + studentClasses + ", colleage=" + colleage
				+ "]";
	}

}
