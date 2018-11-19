package com.OnetoMany.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnetoMany.Repository.Repo;
import com.OnetoMany.dto.Account;
import com.OnetoMany.dto.Employee;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

@Service
public class EmpService {

	@Autowired
	private Repo repo;
	public List<Employee> getAllEmployees()
	{
		return repo.findAll();
	}
	
	public Optional<Employee> getEmployee( Long empId)
	{
		return repo.findById(empId);
	}
	
	public void addEmployee(Employee employee )
	{
		repo.save(employee);
	}
	
	public void UpdateEmployee (Employee employee, Long empId)
	{
		Optional<Employee> emp = repo.findById(empId);
		if (emp.isPresent())
		{
			Employee e = emp.get();
		    e.setEmail(employee.getEmail()); 
		    e.setFirstName(employee.getFirstName());
		    e.setlName(employee.getlName());
		    repo.save(e);
		}
		
	
	}
	
	public void DeleteEmployee( Long empId )
	{
		repo.deleteById(empId);
	

}
	
}
