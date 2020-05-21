package com.capgemini.fms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.fms.dao.AirportDao;
import com.capgemini.fms.dao.BookingDao;
import com.capgemini.fms.dao.FlightDao;
import com.capgemini.fms.dao.PassengerDao;
import com.capgemini.fms.dao.ScheduleDao;
import com.capgemini.fms.dao.ScheduledFlightDao;
import com.capgemini.fms.dao.User1Dao;
import com.capgemini.fms.entity.Airport;
import com.capgemini.fms.entity.Flight;
import com.capgemini.fms.entity.Schedule;
import com.capgemini.fms.entity.User1;

@SpringBootApplication
public class FlightManagementSystemApplication implements CommandLineRunner{

@Autowired
private ScheduledFlightDao scheduledflightDao;
@Autowired
private AirportDao airportDao;
@Autowired
private FlightDao flightDao;
@Autowired
private ScheduleDao scheduleDao;
@Autowired
private PassengerDao passengerDao;
@Autowired
private BookingDao bookingDao;
@Autowired
private User1Dao user1Dao;

public static void main(String[] args) {
SpringApplication.run(FlightManagementSystemApplication.class, args);
}

@Override
public void run(String... args) throws Exception {
Airport air = new Airport("D80","Delhi","Delhi");
Airport air1 = new Airport("H90","Hyedrabad","Ragiv international");
airportDao.save(air);
airportDao.save(air1);
Flight fly = new Flight(1,"I80","Indigo",80);
flightDao.save(fly);
Schedule sc = new Schedule(100, air, air1, null, null);
scheduleDao.save(sc);
Schedule sc1 = new Schedule(101,air,air1, null, null);
scheduleDao.save(sc1);
// ScheduledFlight sf = new ScheduledFlight(10, fly, sc);
// scheduledFlightDao.save(sf);
User1 us = new User1(12,"VIP", "rjt", 123456, "rjt@gmail.com");
user1Dao.save(us);
//Booking book = new Booking(8,500, 1, us,null,fly, null);
//bookingDao.save(book);
// Passenger pass = new Passenger(101, "rjt", 20, 1000000000, 15000.00);
// passengerDao.save(pass);
System.out.println("record inserted");
// TODO Auto-generated method stub

}

}