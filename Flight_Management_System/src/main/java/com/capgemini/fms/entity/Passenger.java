package com.capgemini.fms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "passenger")
@DynamicUpdate(true)
@DynamicInsert(true)

public class Passenger {

//@NotNull(message="prn number is mandatory")
@Id
@Column(name="prnNumber")
//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="prnNumber")
private long prnNumber;

@Column(name="passengerName")
private String passengerName;


@Column(name="age")
private int passengerAge;

@Column(name="passengerUIN")
private long passengerUIN;

@Column(name="Luggage")
private double Luggage;

@ManyToOne
@JoinColumn(name ="bookingId", nullable=false)
private Booking booking;

public long getPrnNumber() {
return prnNumber;
}

public void setPrnNumber(long prnNumber) {
this.prnNumber = prnNumber;
}

public String getPassengerName() {
return passengerName;
}

public void setPassengerName(String passengerName) {
this.passengerName = passengerName;
}

public int getPassengerAge() {
return passengerAge;
}

public void setPassengerAge(int passengerAge) {
this.passengerAge = passengerAge;
}

public long getPassengerUIN() {
return passengerUIN;
}

public void setPassengerUIN(long passengerUIN) {
this.passengerUIN = passengerUIN;
}

public double getLuggage() {
return Luggage;
}

public void setLuggage(double luggage) {
Luggage = luggage;
}

public Booking getBooking() {
return booking;
}

public void setBooking(Booking booking) {
this.booking = booking;
}

@Override
public String toString() {
return "Passenger [prnNumber=" + prnNumber + ", passengerName=" + passengerName + ", passengerAge=" + passengerAge
+ ", passengerUIN=" + passengerUIN + ", Luggage=" + Luggage + ", booking=" + booking + "]";
}

public Passenger(long prnNumber, String passengerName, int passengerAge, long passengerUIN, double luggage,
Booking booking) {
super();
this.prnNumber = prnNumber;
this.passengerName = passengerName;
this.passengerAge = passengerAge;
this.passengerUIN = passengerUIN;
Luggage = luggage;
this.booking = booking;
}

public Passenger() {
super();
// TODO Auto-generated constructor stub
}



}