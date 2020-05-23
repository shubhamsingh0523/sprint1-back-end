package com.capgemini.fms.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.web.PageableDefault;
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
import java.util.Optional;
import com.capgemini.fms.entity.Airport;
import com.capgemini.fms.exception.AirportException;
import com.capgemini.fms.service.AirportService;

@RestController
public class AirportController {
	@Autowired
	private AirportService airportservice;

	@CrossOrigin
	@PostMapping("/addairport")
	public ResponseEntity<String> addAirport(@Valid @RequestBody Airport airport, BindingResult br)
			throws AirportException {
		String err = "";
		if (br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new AirportException(err);
		}
		try {
			airportservice.addairport(airport);
				return new ResponseEntity<String>("Airport added successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new AirportException("Code already exists");
		}
	}
	
	@CrossOrigin
	@GetMapping("/viewallairport")
	public ResponseEntity<List<Airport>> getAirportlist() {
		List<Airport> airportList = airportservice.viewallairport();
		return new ResponseEntity<List<Airport>>(airportList, HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("/deleteairport/{airportCode}")
	public ResponseEntity<String> deleteairport(@PathVariable String airportCode) throws AirportException
	{
		try
		{
			airportservice.deleteairport(airportCode);
			return new ResponseEntity<String>("airport is deleted", HttpStatus.OK);
		}
		catch (DataIntegrityViolationException ex) {
			throw new AirportException("airport code  doesnot exists");
		}
	}
	@CrossOrigin
	@GetMapping("/airportdetails/{airportCode}")
		public Optional<Airport> airportdetails(@PathVariable String airportCode) throws AirportException{
			try {
				return airportservice.airportdetails(airportCode);
			}
			catch (Exception ex)
			{
				throw new AirportException(ex.getMessage());
			}
	}
	
	
	@CrossOrigin
	@PutMapping("/updateairport/{airportCode}")
	public ResponseEntity<String> updateairport(@Valid @RequestBody Airport airport,@PathVariable String airportCode,BindingResult br ) throws AirportException
	{
		String err = "";
		if (br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new AirportException(err);
		}
		try {
			airportservice.updateairport(airport,airportCode);
			return new ResponseEntity<String>("Airport updated successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new AirportException("airport code already exists");
		}
	}
		
	}
		
		
	
	