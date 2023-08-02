package andrearuzittu.Epicodeitjava5D3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import andrearuzittu.Epicodeitjava5D3.model.Booking;
import andrearuzittu.Epicodeitjava5D3.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	public Booking createBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	public Page<Booking> getAllBookings(Pageable pageable) {
		return bookingRepository.findAll(pageable);
	}

	public Booking getBookingById(Long id) {
		return bookingRepository.findById(id).orElse(null);
	}

	public Booking updateBooking(Long id, Booking booking) {
		Booking existingBooking = bookingRepository.findById(id).orElse(null);
		if (existingBooking != null) {
			existingBooking.setDate(booking.getDate());
			existingBooking.setDate(booking.getDate());
			// Aggiungi altri attributi che vuoi aggiornare qui

			return bookingRepository.save(existingBooking);
		} else {
			return null;
		}
	}

	public boolean deleteBooking(Long id) {
		if (bookingRepository.existsById(id)) {
			bookingRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
