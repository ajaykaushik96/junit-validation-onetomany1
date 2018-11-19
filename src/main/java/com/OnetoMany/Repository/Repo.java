package com.OnetoMany.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.OnetoMany.dto.Employee;

@Repository
public interface Repo extends JpaRepository<Employee, Long> {

	@Query
	Employee findByEmpId(Long empId);
	

}
