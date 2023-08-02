package andrearuzittu.Epicodeitjava5D3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import andrearuzittu.Epicodeitjava5D3.model.Booking;
import andrearuzittu.Epicodeitjava5D3.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@GetMapping
	public ResponseEntity<Page<Booking>> getAllBookings(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id,asc") String[] sort) {

		Sort.Direction direction = sort[1].equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by(direction, sort[0]));

		Page<Booking> bookingsPage = bookingService.getAllBookings(pageRequest);
		return new ResponseEntity<>(bookingsPage, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
		Booking booking = bookingService.getBookingById(id);
		if (booking != null) {
			return new ResponseEntity<>(booking, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
		Booking createdBooking = bookingService.createBooking(booking);
		return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
		Booking updatedBooking = bookingService.updateBooking(id, booking);
		if (updatedBooking != null) {
			return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
		boolean deleted = bookingService.deleteBooking(id);
		if (deleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
