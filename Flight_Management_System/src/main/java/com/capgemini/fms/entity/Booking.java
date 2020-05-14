package com.capgemini.fms.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name ="booking")
@DynamicUpdate(true)
@DynamicInsert(true)

public class Booking {
//@NotNull(message="Booking Id Is Mandatory")
@Id
@Column(name="booking_id")
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="booking_id")

private long bookingId;

@NotNull(message="Ticket Cost Is Mandatory")
@Column(name="ticket_cost")
private long ticketCost;

@NotNull(message="No of Passenger Is Mandatory")
@Column(name="no_of_passenger")
private int noOfPassengers;

@ManyToOne
   @JoinColumn(name="user_id", nullable=false)
   private User1 user1;
@OneToMany(mappedBy="booking")
   private List<Passenger> passengerList;

@ManyToOne
   @JoinColumn(name="flight_number", nullable=false)
   private Flight flight;
   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
   private LocalDateTime bookingDate;
public long getBookingId() {
return bookingId;
}
public void setBookingId(long bookingId) {
this.bookingId = bookingId;
}
public long getTicketCost() {
return ticketCost;
}
public void setTicketCost(long ticketCost) {
this.ticketCost = ticketCost;
}
public int getNoOfPassengers() {
return noOfPassengers;
}
public void setNoOfPassengers(int noOfPassengers) {
this.noOfPassengers = noOfPassengers;
}
public User1 getUser1() {
return user1;
}
public void setUser1(User1 user1) {
this.user1 = user1;
}
public List<Passenger> getPassengerList() {
return passengerList;
}
public void setPassengerList(List<Passenger> passengerList) {
this.passengerList = passengerList;
}
public Flight getFlight() {
return flight;
}
public void setFlight(Flight flight) {
this.flight = flight;
}
public LocalDateTime getBookingDate() {
return bookingDate;
}
public void setBookingDate(LocalDateTime bookingDate) {
this.bookingDate = bookingDate;
}
public Booking(long bookingId, long ticketCost, int noOfPassengers, User1 user1, List<Passenger> passengerList,
Flight flight, LocalDateTime bookingDate) {
super();
this.bookingId = bookingId;
this.ticketCost = ticketCost;
this.noOfPassengers = noOfPassengers;
this.user1 = user1;
this.passengerList = passengerList;
this.flight = flight;
this.bookingDate = bookingDate;
}
public Booking() {
super();
// TODO Auto-generated constructor stub
}
@Override
public String toString() {
return "Booking [bookingId=" + bookingId + ", ticketCost=" + ticketCost + ", noOfPassengers=" + noOfPassengers
+ ", user1=" + user1 + ", passengerList=" + passengerList + ", flight=" + flight + ", bookingDate="
+ bookingDate + "]";
}
   


}