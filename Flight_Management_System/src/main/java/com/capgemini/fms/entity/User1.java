package com.capgemini.fms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "User1")
@DynamicUpdate(true)
@DynamicInsert(true)
public class User1 {
//@NotNull(message="UserId Is Mandatory")	
@Id
@Column(name="user_id")
//@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="user_id")
//@SequenceGenerator(sequenceName = "user_id", initialValue = 1, allocationSize = 1, name = "user_id")
private Integer userId;

@Column(name="user_type")
private String userType;
@Column(name="user_name")
private String userName;
//@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{4,14}$")
@Column(name="user_pass")
private int userPassword;
@Column(name="user_email")
private String userEmail;
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public int getUserPassword() {
	return userPassword;
}
public void setUserPassword(int userPassword) {
	this.userPassword = userPassword;
}
public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
public User1(int userId, String userType, String userName, int userPassword, String userEmail) {
	super();
	this.userId = userId;
	this.userType = userType;
	this.userName = userName;
	this.userPassword = userPassword;
	this.userEmail = userEmail;
}
public User1() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "User1 [userId=" + userId + ", userType=" + userType + ", userName=" + userName + ", userPassword="
			+ userPassword + ", userEmail=" + userEmail + "]";
}

}