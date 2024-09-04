package com.valuelabs.trackingnumbergenerator.repository;

import com.valuelabs.trackingnumbergenerator.model.TrackingNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingNumberRepository extends JpaRepository<TrackingNumber, String> {

//    @Query("SELECT t FROM TrackingNumber t WHERE t.trackingNumber = :trackingNumber")
//    Optional<TrackingNumber> existsByTrackingNumber(@Param("trackingNumber") String trackingNumber);
}


