package com.vehicle.servicebooking.controller;
import com.vehicle.servicebooking.model.ServiceBooking;
import com.vehicle.servicebooking.service.ServiceBookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/bookings")
public class ServiceBookingController {
    @Autowired
    private ServiceBookingService service;
    @PostMapping
    public ServiceBooking registerBooking(@Valid @RequestBody ServiceBooking booking) {
        return service.registerBooking(booking);
    }
    @GetMapping
    public List<ServiceBooking> getAllBookings() {
        return service.getAllBookings();
    }
    @GetMapping("/{id}")
    public Optional<ServiceBooking> getBookingById(@PathVariable Long id) {
        return service.getBookingById(id);
    }
    @PutMapping("/{id}")
    public ServiceBooking updateBooking(@PathVariable Long id, @Valid @RequestBody ServiceBooking booking) {
        return service.updateBooking(id, booking);
    }
    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Long id) {
        service.deleteBooking(id);
        return "Booking with ID " + id + " has been deleted.";
    }
}
