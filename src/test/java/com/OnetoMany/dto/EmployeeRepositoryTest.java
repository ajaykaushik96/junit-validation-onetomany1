package com.OnetoMany.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.OnetoMany.Repository.Repo;

@AutoConfigureTestDatabase(replace=Replace.NONE)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DataJpaTest

public class EmployeeRepositoryTest {
	
	
	 @Autowired
	   private TestEntityManager entityManager;
	
	@Autowired
	private Repo empRepo;
	 
	 @Test
	   public void whenFindByEmpId_thenReturnEmployee()
	   {
		 Employee Ajay = new Employee();
		 Ajay.setFirstName("Ajay");
		 Ajay.setlName("Kaushik");
		 Ajay.setEmpId(97l);
		 Ajay.setEmail("ajay21@gmail.com");
		 
		 empRepo.save(Ajay);
		 
		 Employee found =  empRepo.findByEmpId( Ajay.getEmpId() );
		 
		 assertThat( found.getEmail() ).isEqualTo( Ajay.getEmail() );
		 
	   }
	
	
	
	

}
