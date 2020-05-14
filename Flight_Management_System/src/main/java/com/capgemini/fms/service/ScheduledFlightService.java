package com.capgemini.fms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.fms.dao.ScheduledFlightDao;
import com.capgemini.fms.entity.ScheduledFlight;

@Service
@Transactional
public class ScheduledFlightService {
	
	@Autowired
	private ScheduledFlightDao scheduledflightDao;
	
	@Transactional
	public ScheduledFlight addscheduledflight(ScheduledFlight scheduledflight) {
		return scheduledflightDao.save(scheduledflight);
		
	}
	
	@Transactional
	public List<ScheduledFlight> retrieve(){
		List<ScheduledFlight> scheduledflights = new ArrayList<ScheduledFlight>();
		for(ScheduledFlight scheduledflight : scheduledflightDao.findAll()) {
			scheduledflights.add(scheduledflight);
		}
		return scheduledflights;
	}
	
	@Transactional
	public List<ScheduledFlight> showallscheduledflight() {
		return scheduledflightDao.findAll();
	}
	
	@Transactional
	public Optional<ScheduledFlight> scheduledflightdetails(Integer flightNumber){
		return scheduledflightDao.findById(flightNumber);
	}
	
	@Transactional
	public void deletescheduledflight(int availableSeats) {
		scheduledflightDao.deleteById(availableSeats);
	}
	
	@Transactional
	public ScheduledFlight modifyscheduledflight (ScheduledFlight scheduledflight , int availableSeats) {
		return scheduledflightDao.save(scheduledflight);
		
	}

}