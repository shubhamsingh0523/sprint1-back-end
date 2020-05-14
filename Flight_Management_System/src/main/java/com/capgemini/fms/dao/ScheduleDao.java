package com.capgemini.fms.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.fms.entity.Schedule;

@Repository
public interface ScheduleDao extends JpaRepository <Schedule,Integer> {

}

