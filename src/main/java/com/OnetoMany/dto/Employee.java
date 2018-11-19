package com.OnetoMany.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@JsonPropertyOrder(value= {"empId", "email", "firstName", "lName"} , alphabetic=true)
@JsonRootName(value="Employee")
public class Employee {
       
	 
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
     private Long empId;
	 
	 
	 
	 
		@NotNull(message = "Email Id is required")
		@Size(min = 5, max = 50, message = "Invalid length for email")
		@Pattern(message = "Invalid email id", regexp = "^.+@.+\\..+$")
     private String email;
		
		
     @NotEmpty
     @JsonRawValue
     @JsonProperty(value="Employee_First_Name")
     private String firstName;
     
     @Size(min=0,max=20)
 	@Pattern(regexp="^[A-Za-z]*$")
     private String lName;
     
     @OneToMany(cascade=CascadeType.ALL)
     private Set<Account> account ;
     
     
     
	public Employee(Long empId,
			@NotNull(message = "Email Id is required") @Size(min = 5, max = 50, message = "Invalid length for email") @Pattern(message = "Invalid email id", regexp = "^.+@.+\\..+$") String email,
			@NotEmpty String firstName, @Size(min = 0, max = 20) @Pattern(regexp = "^[A-Za-z]*$") String lName) {
		super();
		this.empId = empId;
		this.email = email;
		this.firstName = firstName;
		this.lName = lName;
	}
	public Employee() {
		super();
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
     
     
	
	
}
