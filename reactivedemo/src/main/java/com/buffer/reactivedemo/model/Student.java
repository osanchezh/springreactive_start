package com.buffer.reactivedemo.model;


import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("student")
public class Student {

  @Id
  private Long id;
  private String firstname;
  private String lastname;
  private int age;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
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
	return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + "]";
}
@Override
public int hashCode() {
	return Objects.hash(age, firstname, id, lastname);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Student other = (Student) obj;
	return age == other.age && Objects.equals(firstname, other.firstname) && Objects.equals(id, other.id)
			&& Objects.equals(lastname, other.lastname);
}
public Student(Long id, String firstname, String lastname, int age) {
	super();
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.age = age;
}
public Student() {
	super();
}

}