package com.OnlineBookShop.models;

public class Customer {
String Login_Id;
String password;
String name;
String location;
String address;
String mail;
Long mobile;

public Customer() {
	super();
	
}

public Customer(String login_Id, String password, String name, String location, String address, String mail,
		Long mobile) {
	super();
	Login_Id = login_Id;
	this.password = password;
	this.name = name;
	this.location = location;
	this.address = address;
	this.mail = mail;
	this.mobile = mobile;
}

@Override
public String toString() {
	return "Customer [Login_Id=" + Login_Id + ", password=" + password + ", name=" + name + ", location=" + location
			+ ", address=" + address + ", mail=" + mail + ", mobile=" + mobile + "]";
}

public String getLogin_Id() {
	return Login_Id;
}

public void setLogin_Id(String login_Id) {
	Login_Id = login_Id;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getMail() {
	return mail;
}

public void setMail(String mail) {
	this.mail = mail;
}

public Long getMobile() {
	return mobile;
}

public void setMobile(Long mobile) {
	this.mobile = mobile;
}



}