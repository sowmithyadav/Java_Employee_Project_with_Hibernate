package com.flm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Employee {
	
  public Employee(int id, String name, String address, int salary) {
	  
	  this.id = id;
	  this.name = name;
	  this.address = address;
	  this.salary = salary;

	}

private int id;
  
  private String name;
  
  private String address;
  
  private int salary;
}
