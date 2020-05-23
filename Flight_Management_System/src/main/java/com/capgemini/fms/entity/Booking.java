package com.capgemini.fms.entity;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;



@Entity
@Table(name="booking")
@DynamicUpdate(true)
@DynamicInsert(true)

public class Booking{

	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bk_seq")
	// @SequenceGenerator(sequenceName = "bk_seq", allocationSize = 1, name = "bk_seq")
	//// @GeneratedValue
	@GeneratedValue(strategy = GenerationType.AUTO)
	long  bookingId;
	
	@OneToOne(fetch=FetchType.EAGER)
	User1 user;
	
	//LocalDateTime Bookingdate;
	@JsonDeserialize(using = DateDeserializer .class)
	 private Date Bookingdate;
	
	   @OneToMany(fetch=FetchType.EAGER)
	 	private List<Passenger> passengerList;
	
	double ticketCost;
	
	@OneToOne(fetch=FetchType.EAGER)
	Flight flight;
	
	int noOfPassengers;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(long bookingId, User1 user, Date bookingdate, List<Passenger> passengerList, double ticketCost,
			Flight flight, int noOfPassengers) {
		super();
		this.bookingId = bookingId;
		this.user = user;
		Bookingdate = bookingdate;
		this.passengerList = passengerList;
		this.ticketCost = ticketCost;
		this.flight = flight;
		this.noOfPassengers = noOfPassengers;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public User1 getUser() {
		return user;
	}

	public void setUser(User1 user) {
		this.user = user;
	}

	public Date getBookingdate() {
		return Bookingdate;
	}

	public void setBookingdate(Date bookingdate) {
		Bookingdate = bookingdate;
	}

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	public double getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", user=" + user + ", Bookingdate=" + Bookingdate
				+ ", passengerList=" + passengerList + ", ticketCost=" + ticketCost + ", flight=" + flight
				+ ", noOfPassengers=" + noOfPassengers + "]";
	}

	
}