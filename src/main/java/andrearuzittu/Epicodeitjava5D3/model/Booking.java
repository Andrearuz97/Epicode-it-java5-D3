package andrearuzittu.Epicodeitjava5D3.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private LocalDate date;

	@ManyToOne
	private Workstation workstation;

	@ManyToOne
	private Utente user;

	public Booking() {
	}

	public Booking(LocalDate date, Workstation workstation, Utente user) {
		this.date = date;
		this.workstation = workstation;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Workstation getWorkstation() {
		return workstation;
	}

	public void setWorkstation(Workstation workstation) {
		this.workstation = workstation;
	}

	public Utente getUser() {
		return user;
	}

	public void setUser(Utente user) {
		this.user = user;
	}
}
