package many_to_one_uni;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Director {
	@Id
	private int id;
	private String name;
	private String industry;
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
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	@Override
	public String toString() {
		return "Director [id=" + id + ", name=" + name + ", industry=" + industry + "]";
	}
	
	
}
