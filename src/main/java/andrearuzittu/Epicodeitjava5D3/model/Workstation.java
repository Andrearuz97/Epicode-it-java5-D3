package andrearuzittu.Epicodeitjava5D3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Workstation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private String description;

	@Enumerated(EnumType.STRING)
	private WorkstationType type;

	private int maxOccupants;

	@ManyToOne
	private Building building;

	public Workstation() {
	}

	public Workstation(String code, String description, WorkstationType type, int maxOccupants, Building building) {
		this.code = code;
		this.description = description;
		this.type = type;
		this.maxOccupants = maxOccupants;
		this.building = building;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public WorkstationType getType() {
		return type;
	}

	public void setType(WorkstationType type) {
		this.type = type;
	}

	public int getMaxOccupants() {
		return maxOccupants;
	}

	public void setMaxOccupants(int maxOccupants) {
		this.maxOccupants = maxOccupants;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}
}