package mvc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_student")
public class Student {
	@Id
	@GeneratedValue
	private int Id;

	@Column(unique = true)
	private String studentName;
	private String password;
	private String nickname;
	private int age;

	@ManyToOne(fetch = FetchType.LAZY, cascade = (CascadeType.ALL)) // 延迟加载方式加载对象
	private StudentClass studentClass;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String studentName, String password, String nickname, int age) {
		super();
		Id = id;
		this.studentName = studentName;
		this.password = password;
		this.nickname = nickname;
		this.age = age;
	}
}
