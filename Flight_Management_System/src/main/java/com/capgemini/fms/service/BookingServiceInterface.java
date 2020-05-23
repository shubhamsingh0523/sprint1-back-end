package com.capgemini.fms.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.fms.entity.Booking;

public interface BookingServiceInterface {
	public boolean addbooking(Booking bookingId);
	public List<Booking> show();
	public Optional<Booking> bookingdetails(long bookingId);
	public void deletebooking(long bookingId);
	public Booking updatebooking(Booking booking);
	

}