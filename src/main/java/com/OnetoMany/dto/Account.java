package com.OnetoMany.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Account {

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accNo;

	
	@Size(min =  2 , max = 10)
	private Integer iFSCCode;

	@ManyToOne(cascade = CascadeType.ALL)

	private Employee employee;

	

	public Integer getiFSCCode() {
		return iFSCCode;
	}

	public void setiFSCCode(Integer iFSCCode) {
		this.iFSCCode = iFSCCode;
	}

	public Long getAccNo() {
		return accNo;
	}

	public void setAccNo(Long accNo) {
		this.accNo = (long) accNo;
	}

}
