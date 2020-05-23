package com.capgemini.fms.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.capgemini.fms.entity.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.fms.dao.AirportDao;

@Service
public class AirportService {
	@Autowired
	private AirportDao airportDao;
	@Transactional
	public boolean addairport(Airport airport)
	{
		return airportDao.save(airport)!=null;
	}
	@Transactional
	public void  deleteairport(String airportCode)
	{
		airportDao.deleteById(airportCode);
	}
	@Transactional
	public List<Airport> viewallairport(){
		return airportDao.findAll();
	}
	@Transactional
	public boolean updateairport(Airport airport,String airportCode)
	{   airport.setAirportLocation(airport.getAirportLocation());
		return airportDao.save(airport)!=null;
	}
	@Transactional
	public Optional<Airport> airportdetails(String airportCode){
		return airportDao.findById(airportCode);
	}

}