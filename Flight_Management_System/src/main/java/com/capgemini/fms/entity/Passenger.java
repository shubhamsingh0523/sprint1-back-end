package com.capgemini.fms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "passenger")
@DynamicUpdate(true)
@DynamicInsert(true)

public class Passenger {

@Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bk_seq")
  @SequenceGenerator(sequenceName = "bk_seq", allocationSize = 1, name = "bk_seq")

  // @GeneratedValue(strategy = GenerationType.AUTO)
 
  long pnrNumber;
     @Pattern(regexp = "^[\\p{L} .'-]+$", message = "Name should not contain special characters.")
     String passengerName;
     int passengerAge;
     String gender;
   
     long Id;



public Passenger(long pnrNumber, String passengerName, int passengerAge, String gender, long id) {
this.pnrNumber = pnrNumber;
this.passengerName = passengerName;
this.passengerAge = passengerAge;
this.gender = gender;
Id = id;
}
public long getId() {
return Id;
}
public void setId(long id) {
Id = id;
}
public Passenger() {
// TODO Auto-generated constructor stub
}
public String getGender() {
return gender;
}
public void setGender(String gender) {
this.gender = gender;
}
public long getPnrNumber() {
return pnrNumber;
}
public void setPnrNumber(long pnrNumber) {
this.pnrNumber = pnrNumber;
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


}
