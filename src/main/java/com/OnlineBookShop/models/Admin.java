package com.OnlineBookShop.models;

public class Admin {
String Login_Id;
String password;
String name;
String empId;
public Admin() {
	super();
	
}
public Admin(String Login_Id, String password, String name, String empId) {
	super();
	this.Login_Id = Login_Id;
    this.password = password;
	this.name = name;
	this.empId = empId;
}
@Override
public String toString() {
	return "Admin [Login_Id=" + Login_Id + ", password=" + password + ", name=" + name + ", empId=" + empId + "]";
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
public String getEmpId() {
	return empId;
}
public void setEmpId(String empId) {
	this.empId = empId;
}

}
