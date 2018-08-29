package mvc.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_colleage")
public class Colleage {
	@Id
	@GeneratedValue
	private int Id;

	@Column(unique = true)
	private String name;

	private String address;

	@OneToMany(mappedBy = "colleage", cascade = (CascadeType.ALL), fetch = FetchType.EAGER)
	private Set<Academy> academies;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Academy> getAcademies() {
		return academies;
	}

	public void setAcademies(Set<Academy> academies) {
		this.academies = academies;
	}

	public Colleage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Colleage(int id, String name, String address, Set<Academy> academies) {
		super();
		Id = id;
		this.name = name;
		this.address = address;
		this.academies = academies;
	}

	@Override
	public String toString() {
		return "Colleage [Id=" + Id + ", name=" + name + ", address=" + address + "]";
	}

}
