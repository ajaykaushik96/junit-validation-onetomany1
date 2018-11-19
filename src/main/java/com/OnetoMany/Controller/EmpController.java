package com.OnetoMany.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.OnetoMany.Service.EmpService;
import com.OnetoMany.dto.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;

@RestController
public class EmpController {
	
	
	@Autowired
	private EmpService empService;
   
	@GetMapping("/employee")
	
	public List<Employee> getAllEmployees()
	{
		return empService.getAllEmployees();
	}
	
	@GetMapping("/employee/{empId}")
	public Optional<Employee> getEmployee( @PathVariable Long empId)
	{
		return empService.getEmployee(empId);
	}
	
	@PostMapping("/employee")
	public void addEmployee(@RequestBody Employee employee )
	{
		empService.addEmployee(employee);
	}
	
	@PutMapping("/employee/{empId}")
	public void UpdateEmployee (@RequestBody Employee employee,@PathVariable Long empId)
	{
		empService.UpdateEmployee(employee, empId);
	}

	public void DeleteEmployee( Long empId )
	{
		empService.DeleteEmployee(empId);
	}

}
