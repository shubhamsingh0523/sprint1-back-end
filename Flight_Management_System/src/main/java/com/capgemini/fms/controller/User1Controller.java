package com.capgemini.fms.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.fms.entity.Flight;
import com.capgemini.fms.entity.User1;
import com.capgemini.fms.exception.User1Exception;
import com.capgemini.fms.service.User1Service;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class User1Controller {

@Autowired
private User1Service user1service;


@PostMapping("/addUser1")
@CrossOrigin(origins="http://localhost:4200")
public ResponseEntity<String> addUser1(@Valid @RequestBody User1 user1, BindingResult br)
throws User1Exception {
String err = "";
if (br.hasErrors()) {
List<FieldError> errors = br.getFieldErrors();
for (FieldError error : errors)
err += error.getDefaultMessage() + "<br/>";
throw new User1Exception(err);
}
try {
user1service.addUser1(user1);
return new ResponseEntity<String>("User Id added successfully", HttpStatus.OK);

} catch (DataIntegrityViolationException ex) {
throw new User1Exception("ID already exists");
}
}



@GetMapping("/viewallUser1")
@CrossOrigin(origins="http://localhost:4200")
public ResponseEntity<List<User1>> getlist() {
List<User1> user1List = user1service.show();
return new ResponseEntity<List<User1>>(user1List, HttpStatus.OK);
}


@DeleteMapping("/deleteUser1/{userId}")
@CrossOrigin(origins="http://localhost:4200")
public ResponseEntity<String> deleteUser1(@PathVariable Integer userId) throws User1Exception
{
try
{
user1service.deleteUser1( userId);
return new ResponseEntity<String>("user id is deleted", HttpStatus.OK);
}
catch (DataIntegrityViolationException ex) {
throw new User1Exception("ID doesnot exists");
}
}


@PutMapping("/updateUser1/{id}")
@CrossOrigin(origins="http://localhost:4200")
public ResponseEntity updateflight(@Valid @RequestBody User1 user1,@RequestParam Integer userId,BindingResult br ) throws User1Exception
{
String err = "";
if (br.hasErrors()) {
List<FieldError> errors = br.getFieldErrors();
for (FieldError error : errors)
err += error.getDefaultMessage() + "<br/>";
throw new User1Exception(err);
}
try {
user1service.updateUser1(user1,userId);
return new ResponseEntity<String>("user id updated successfully", HttpStatus.OK);

} catch (DataIntegrityViolationException ex) {
throw new User1Exception("User id already exists");
}
}

@GetMapping("/viewbyuserid/{userId}")
@CrossOrigin(origins="http://localhost:4200")
public Optional<User1> User1details(@PathVariable Integer userId) throws User1Exception{
try {
return user1service.User1details(userId);
}
catch(Exception ex)
{
throw new User1Exception(ex.getMessage());
}
}
}