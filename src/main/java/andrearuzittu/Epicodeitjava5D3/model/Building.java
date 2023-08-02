package andrearuzittu.Epicodeitjava5D3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Building {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String name;
	private String address;
	private String city;

	public Building() {
	}

	public Building(String name, String address, String city) {
		this.name = name;
		this.address = address;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
