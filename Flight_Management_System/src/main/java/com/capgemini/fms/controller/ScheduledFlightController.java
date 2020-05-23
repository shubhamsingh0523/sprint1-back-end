package com.capgemini.fms.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.fms.entity.ScheduledFlight;
import com.capgemini.fms.exception.ScheduledFlightException;
import com.capgemini.fms.service.ScheduledFlightService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ScheduledFlightController {
	
	@Autowired
	private ScheduledFlightService scheduledflightservice;
	
	@PostMapping("/addscheduledflight")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<String> addscheduledflight(@Valid @RequestBody ScheduledFlight scheduledflight , BindingResult br) throws ScheduledFlightException {
		String err = " ";
		if(br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for(FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new ScheduledFlightException(err);
		}
		try {
			scheduledflightservice.addscheduledflight(scheduledflight);
			return new ResponseEntity<String>("Scheduled FLight added Complete", HttpStatus.OK);
		}
		catch(DataIntegrityViolationException ex) {
			throw new ScheduledFlightException("No scheduled flight");
		}
	}
	
	@GetMapping("/viewallscheduledflight")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<ScheduledFlight>> getScheduledFlightlist(){
		List<ScheduledFlight> scheduledflightlist = scheduledflightservice.showallscheduledflight();
		return new ResponseEntity<List<ScheduledFlight>>(scheduledflightlist , HttpStatus.OK);
	}
	
	@DeleteMapping("/deletescheduledflight/{availableSeats}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity deletescheduledflight(@PathVariable Integer availableSeats) throws ScheduledFlightException {
		try {
			scheduledflightservice.deletescheduledflight(availableSeats);
			return new ResponseEntity<String>("Scheduled Flight deleted", HttpStatus.OK);
		}
		catch (DataIntegrityViolationException ex) {
			throw new ScheduledFlightException("availableSeats not available");
		}
	}
	
	@PutMapping("/modifyscheduledflight/{availableSeats}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity modifyscheduledflight(@Valid @RequestBody ScheduledFlight scheduledflight,@PathVariable Integer availableSeats,BindingResult br ) throws ScheduledFlightException
	{
		String err = " ";
		if(br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for(FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new ScheduledFlightException(err);
		}
		try {
			scheduledflightservice.modifyscheduledflight(scheduledflight, availableSeats);
			return new ResponseEntity<String> ("Modification Complete", HttpStatus.OK);
		}
		catch (DataIntegrityViolationException ex) {
			throw new ScheduledFlightException("unavailable scheduled flight");
		}
	}
	
	@GetMapping("/getscheduledflightdetails/{availableSeats}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Optional<ScheduledFlight>scheduledflightdetails(@PathVariable Integer availableSeats) throws ScheduledFlightException{
		try {
			return scheduledflightservice.scheduledflightdetails(availableSeats);
		}
		catch(Exception ex) {
			throw new ScheduledFlightException(ex.getMessage());
		}
	}

}