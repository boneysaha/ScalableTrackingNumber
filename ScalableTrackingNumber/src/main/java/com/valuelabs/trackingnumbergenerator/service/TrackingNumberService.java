package com.valuelabs.trackingnumbergenerator.service;

import com.valuelabs.trackingnumbergenerator.model.TrackingNumber;
import com.valuelabs.trackingnumbergenerator.repository.TrackingNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class TrackingNumberService {

    private final TrackingNumberRepository trackingNumberRepository;

    @Autowired
    public TrackingNumberService(TrackingNumberRepository trackingNumberRepository) {
        this.trackingNumberRepository = trackingNumberRepository;
    }

    public String generateTrackingNumber(
            String originCountryId, String destinationCountryId, String weight, String createdAt, String customerId,
            String customerName, String customerSlug) {

        // Generate a unique tracking number based on the input parameters
        String trackingNumber = UUID.nameUUIDFromBytes(
                (originCountryId + destinationCountryId + weight + createdAt + customerId + customerName + customerSlug).getBytes())
                .toString().toUpperCase();

        // Validate the generated tracking number
        if (!trackingNumber.matches("^[A-Z0-9]{1,16}$")) {
            throw new IllegalArgumentException("Invalid tracking number");
        }

        // Check if the tracking number already exists
//        if (trackingNumberRepository.existsByTrackingNumber(trackingNumber).isPresent()) {
//            throw new IllegalArgumentException("Tracking number already exists");
//        }

        // Save the tracking number to the database
        TrackingNumber trackingNumberEntity = new TrackingNumber();
        trackingNumberEntity.setTrackingNumber(trackingNumber);
        trackingNumberEntity.setCreatedAt(new Date());
        trackingNumberRepository.save(new TrackingNumber());

        return trackingNumber;
    }
}
