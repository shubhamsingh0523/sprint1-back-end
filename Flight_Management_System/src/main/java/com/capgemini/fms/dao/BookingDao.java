package com.capgemini.fms.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.fms.entity.Booking;
@Repository
public interface BookingDao extends JpaRepository<Booking , Long>{

}


