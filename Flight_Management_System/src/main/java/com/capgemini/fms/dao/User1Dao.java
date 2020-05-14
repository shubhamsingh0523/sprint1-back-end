package com.capgemini.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.fms.entity.User1;

@Repository
public interface User1Dao  extends JpaRepository<User1, Integer>{

}