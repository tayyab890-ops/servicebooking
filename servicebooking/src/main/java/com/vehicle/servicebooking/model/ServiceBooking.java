package com.vehicle.servicebooking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
    private Long id;

    @NotBlank(message = "Vehicle model is required")
    private String vehicleModel;

    @NotBlank(message = "Registration number is required")
    private String registrationNumber;

    @NotBlank(message = "Service type is required")
    private String serviceType;

    private LocalDate preferredDate;
}
