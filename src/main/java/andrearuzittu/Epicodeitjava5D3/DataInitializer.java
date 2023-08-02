package andrearuzittu.Epicodeitjava5D3;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import andrearuzittu.Epicodeitjava5D3.model.Booking;
import andrearuzittu.Epicodeitjava5D3.model.Building;
import andrearuzittu.Epicodeitjava5D3.model.Utente;
import andrearuzittu.Epicodeitjava5D3.model.Workstation;
import andrearuzittu.Epicodeitjava5D3.model.WorkstationType;
import andrearuzittu.Epicodeitjava5D3.repository.BookingRepository;
import andrearuzittu.Epicodeitjava5D3.repository.BuildingRepository;
import andrearuzittu.Epicodeitjava5D3.repository.UserRepository;
import andrearuzittu.Epicodeitjava5D3.repository.WorkstationRepository;

@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BuildingRepository buildingRepository;

	@Autowired
	private WorkstationRepository workstationRepository;

	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public void run(String... args) throws Exception {
		// Popolamento dell'utente
		Utente user1 = new Utente("Andrea_ruz97", "Andrea Ruzittu", "ruzittu.andrea97@gmail.com");
		user1 = userRepository.save(user1);

		Utente user2 = new Utente("Mario_123", "Mario Rossi", "mario.rossi@live.com");
		user2 = userRepository.save(user2);

		Utente user3 = new Utente("Gigi_xD", "Gigi Proietti", "gigioproie@hotmail.it");
		user3 = userRepository.save(user3);

		Utente user4 = new Utente("Ajeje_65", "Ajeje Brazorf", "ajeje.braz65@yahoo.it");
		user4 = userRepository.save(user4);

		Utente user5 = new Utente("Giuseppe_green", "Giuseppe Verdi", "pepgreen@libero.it");
		user5 = userRepository.save(user5);

		// Popolamento dell'edificio
		Building building1 = new Building("Edificio A", "Via xx Settembre 16C", "Roma");
		building1 = buildingRepository.save(building1);

		Building building2 = new Building("Edificio B", "Via Maradona 80B", "Napoli");
		building2 = buildingRepository.save(building2);

		Building building3 = new Building("Edificio C", "Via Giotto 15A", "Olbia");
		building3 = buildingRepository.save(building3);

		Building building4 = new Building("Edificio D", "Via Dei Caduti 55A", "Genova");
		building4 = buildingRepository.save(building4);

		Building building5 = new Building("Edificio E", "Via Della Seta 1F", "Torino");
		building5 = buildingRepository.save(building5);

		// Popolamento della postazione
		Workstation workstation1 = new Workstation("WS001", "Scrivania 1", WorkstationType.PRIVATO, 1, building1);
		workstation1 = workstationRepository.save(workstation1);

		Workstation workstation2 = new Workstation("WS002", "Scrivania 2", WorkstationType.OPENSPACE, 1, building2);
		workstation2 = workstationRepository.save(workstation2);

		Workstation workstation3 = new Workstation("WS003", "Scrivania 3", WorkstationType.PRIVATO, 1, building3);
		workstation3 = workstationRepository.save(workstation3);

		Workstation workstation4 = new Workstation("WS004", "Scrivania 4", WorkstationType.OPENSPACE, 1, building4);
		workstation4 = workstationRepository.save(workstation4);

		Workstation workstation5 = new Workstation("WS005", "Scrivania 5", WorkstationType.OPENSPACE, 1, building5);
		workstation5 = workstationRepository.save(workstation5);

		// Prenotazione delle postazioni per gli utenti
		Booking booking1 = new Booking(LocalDate.now(), workstation1, user1);
		booking1 = bookingRepository.save(booking1);

		Booking booking2 = new Booking(LocalDate.now().plusDays(1), workstation2, user2);
		booking2 = bookingRepository.save(booking2);

		Booking booking3 = new Booking(LocalDate.now().plusDays(1), workstation3, user3);
		booking3 = bookingRepository.save(booking3);

		Booking booking4 = new Booking(LocalDate.now().plusDays(1), workstation4, user4);
		booking4 = bookingRepository.save(booking4);

		Booking booking5 = new Booking(LocalDate.now().plusDays(1), workstation5, user5);
		booking5 = bookingRepository.save(booking5);
	}
}
