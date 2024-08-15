package com.buffer.reactivedemo.model;

import java.util.Objects;

public class StudentRequest {

  private String firstname;
  private String lastname;
  private int age;
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@Override
public String toString() {
	return "StudentRequest [firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + "]";
}
@Override
public int hashCode() {
	return Objects.hash(age, firstname, lastname);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	StudentRequest other = (StudentRequest) obj;
	return age == other.age && Objects.equals(firstname, other.firstname) && Objects.equals(lastname, other.lastname);
}
public StudentRequest(String firstname, String lastname, int age) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.age = age;
}
public StudentRequest() {
	super();
}


}