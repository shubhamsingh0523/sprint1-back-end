package com.capgemini.fms.controller;
import java.util.List;

import javax.validation.Valid;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.fms.entity.Airport;
import com.capgemini.fms.entity.Flight;
import com.capgemini.fms.exception.FlightException;
import com.capgemini.fms.service.FlightService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class FlightController {
	@Autowired
	private FlightService flightservice;

	@CrossOrigin
	@PostMapping("/addflight")
	public ResponseEntity<String> addFlight(@Valid @RequestBody Flight flight, BindingResult br)
			throws FlightException {
		String err = "";
		if (br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new FlightException(err);
		}
		try {
			flightservice.addflight(flight);
			return new ResponseEntity<String>("Flight added successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new FlightException("ID already exists");
		}
	}

	@CrossOrigin
	@GetMapping("/viewallflight")
	public ResponseEntity<List<Flight>> getFlightlist() {
		List<Flight> flightList = flightservice.show();
		return new ResponseEntity<List<Flight>>(flightList, HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("/deleteflight/{flightNumber}")
	public ResponseEntity<String> deleteflight( @PathVariable Integer flightNumber) throws FlightException
	{
		try
		{
			flightservice.deleteflight( flightNumber);
			return new ResponseEntity<String>("flight is deleted", HttpStatus.OK);
		}
		catch (DataIntegrityViolationException ex) {
			throw new FlightException("flight number  doesnot exists");
		}
	}
	
	@CrossOrigin
	@PutMapping("/updateflight/{flightNumber}")
	public ResponseEntity<String> updateflight(@Valid @RequestBody Flight flight,@PathVariable Integer flightNumber,BindingResult br ) throws FlightException
	{
		String err = "";
		if (br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new FlightException(err);
		}
		try {
			flightservice.updateflight(flight,flightNumber);
			return new ResponseEntity<String>("Flight updated successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new FlightException("flight number already exists");
		}
	}
	@CrossOrigin
	@GetMapping("/view-by-id/{flightNumber}")
	public Optional<Flight> flightdetails(@PathVariable Integer flightNumber) throws FlightException{
		try {
			return flightservice.flightdetails(flightNumber);
		}
		catch(Exception ex)
		{
			throw new FlightException(ex.getMessage());
		}
	}
		
	}
		

	
	


