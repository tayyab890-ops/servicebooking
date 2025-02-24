package com.vehicle.servicebooking.service;
import com.vehicle.servicebooking.model.ServiceBooking;
import com.vehicle.servicebooking.repository.ServiceBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ServiceBookingService {
    @Autowired
    private ServiceBookingRepository repository;
    public ServiceBooking registerBooking(ServiceBooking booking) {
        return repository.save(booking);
    }
    public List<ServiceBooking> getAllBookings() {
        return repository.findAll();}
    public Optional<ServiceBooking> getBookingById(Long id) {
        return repository.findById(id);
    }
    public ServiceBooking updateBooking(Long id, ServiceBooking newBooking) {
        return repository.findById(id).map(booking -> {
            booking.setVehicleModel(newBooking.getVehicleModel());
            booking.setRegistrationNumber(newBooking.getRegistrationNumber());
            booking.setServiceType(newBooking.getServiceType());
            booking.setPreferredDate(newBooking.getPreferredDate());
            return repository.save(booking);
        }).orElseThrow(() -> new RuntimeException("Booking not found!"));
    }
    public void deleteBooking(Long id) {
        repository.deleteById(id);}
}
