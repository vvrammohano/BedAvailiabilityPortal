package com.project.BedBookingService;

import com.project.BedBookingService.entity.Booking;
import com.project.BedBookingService.repository.BookingRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class BedBookingServiceApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Test
	public void saveBedBookingService() {
		Booking booking = Booking.builder()
				.bedId(2L)
				.bedType("Oxygenated")
				.bedAvailability("Available")
				.bedPrice(2000L)
				.build();
		bookingRepository.save(booking);
		Assertions.assertThat(booking.getBedId()).isGreaterThan(0);

	}

	@Test
	public void updateBedBookingService() {
		Booking booking = bookingRepository.findById(String.valueOf(3L)).get();
		booking.setBedType("Oxygenated");
		booking.setBedAvailability("Available");
		Booking bookingupdated = bookingRepository.save(booking);
		Assertions.assertThat(bookingupdated.getBedType()).isEqualTo("Oxygenated");
		Assertions.assertThat(bookingupdated.getBedAvailability()).isEqualTo("Available");
	}

	@Test
	public void getAll() {
		List<Booking> rooms = bookingRepository.findAll();
		Assertions.assertThat(rooms.size()).isGreaterThan(0);
	}

	@Test
	public void getBookingByBedId() {
		Booking booking = bookingRepository.findBookingByBedId(1L);
		Assertions.assertThat(booking.getBedId()).isEqualTo(1);
	}

	@Test
	public void deleteBooking() {
		Booking booking = bookingRepository.findById(String.valueOf(1L)).get();
		bookingRepository.delete(booking);
		Booking booking1 = null;
		Optional<Booking> optionalBooking = bookingRepository.findById(String.valueOf(1L));
		if (optionalBooking.isPresent()) {
			booking1 = optionalBooking.get();
		}
		Assertions.assertThat(booking1).isNull();


	}
}
