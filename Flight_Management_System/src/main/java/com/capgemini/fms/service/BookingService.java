package com.capgemini.fms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.fms.dao.BookingDao;
import com.capgemini.fms.entity.Booking;



@Service

public class BookingService {
	
	@Autowired
	private BookingDao bookingDao;
	
	@Transactional
	public boolean addbooking(Booking bookingId)
	{
		return bookingDao.save(bookingId) !=null;
	}
	@Transactional
	public List<Booking> show()
	{
		return bookingDao.findAll();
	}
	@Transactional
	public Optional<Booking> bookingdetails(long bookingId)
	{
		return bookingDao.findById(bookingId);
	}
	@Transactional
	public void deletebooking(long bookingId)
	{
		bookingDao.deleteById(bookingId);
		
	}
	
	@Transactional
	public Booking updatebooking(Booking booking,long bookingId)
	{
		return bookingDao.save(booking);
	}
	
}