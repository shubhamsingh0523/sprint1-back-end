package com.capgemini.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.fms.entity.Passenger;

@Repository
public interface PassengerDao extends JpaRepository<Passenger, Long> {

}

