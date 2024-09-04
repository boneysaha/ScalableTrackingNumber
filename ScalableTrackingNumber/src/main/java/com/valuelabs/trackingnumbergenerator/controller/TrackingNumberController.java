package com.valuelabs.trackingnumbergenerator.controller;

import com.valuelabs.trackingnumbergenerator.model.TrackingNumberResponse;
import com.valuelabs.trackingnumbergenerator.service.TrackingNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class TrackingNumberController {

    private final TrackingNumberService trackingNumberService;

    @Autowired
    public TrackingNumberController(TrackingNumberService trackingNumberService) {
        this.trackingNumberService = trackingNumberService;
    }

    @GetMapping("/next-tracking-number")
    public TrackingNumberResponse generateTrackingNumber(
            @RequestParam("origin_country_id") String originCountryId,
            @RequestParam("destination_country_id") String destinationCountryId,
            @RequestParam("weight") String weight,
            @RequestParam("created_at") String createdAt,
            @RequestParam("customer_id") String customerId,
            @RequestParam("customer_name") String customerName,
            @RequestParam("customer_slug") String customerSlug) {

        String trackingNumber = trackingNumberService.generateTrackingNumber(
                originCountryId, destinationCountryId, weight, createdAt, customerId, customerName, customerSlug);

        return new TrackingNumberResponse(trackingNumber, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
    }
}
