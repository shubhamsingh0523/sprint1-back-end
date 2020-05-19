package com.capgemini.fms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.fms.dao.FlightDao;
import com.capgemini.fms.entity.Flight;



@Service

public class FlightService {
	
	@Autowired
	private FlightDao flightDao;
	
	@Transactional
	public boolean addflight(Flight flight)
	{
		return flightDao.save(flight) !=null;
	}
	@Transactional
	public List<Flight>show()
	{
		return flightDao.findAll();
	}
	@Transactional
	public Optional<Flight> flightdetails(Integer flightNumber)
	{
		return flightDao.findById(flightNumber);
	}
	@Transactional
	public void deleteflight(Integer flightNumber)
	{
		flightDao.deleteById(flightNumber);
		
	}
	
	@Transactional
	public boolean updateflight(Flight flight,Integer flightNumber)
	
	{
		flight.setFlightModel(flight.getFlightModel());
		return flightDao.save(flight) !=null;
	}
	
}


