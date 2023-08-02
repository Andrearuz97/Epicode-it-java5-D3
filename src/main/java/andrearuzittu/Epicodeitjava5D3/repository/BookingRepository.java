package andrearuzittu.Epicodeitjava5D3.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import andrearuzittu.Epicodeitjava5D3.model.Booking;
import andrearuzittu.Epicodeitjava5D3.model.Utente;
import andrearuzittu.Epicodeitjava5D3.model.Workstation;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	List<Booking> findByUser(Utente user);

	Booking findByDateAndWorkstation(LocalDate date, Workstation workstation);
}
