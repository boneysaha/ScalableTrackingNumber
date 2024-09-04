package com.valuelabs.trackingnumbergenerator.model;

import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;


@Entity
public class TrackingNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String trackingNumber;

    @Column
    private Date createdAt;

    public TrackingNumber() {
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber =  trackingNumber;
    }

    public void setCreatedAt(Date date) {
        this.createdAt =  date;
    }
}

