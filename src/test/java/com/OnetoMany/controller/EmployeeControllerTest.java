package com.OnetoMany.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.OnetoMany.Controller.EmpController;
import com.OnetoMany.Service.EmpService;
import com.OnetoMany.dto.Employee;









@RunWith(SpringRunner.class)
@WebMvcTest(value = EmpController.class,secure=false)
public class EmployeeControllerTest {

	
	private MockMvc mockMvc;

	@MockBean
	private EmpService empService;
	@Autowired
	WebApplicationContext webApplicationContext;
	
	Employee mockEmp;

	List<Employee> emp=new ArrayList<Employee>();
	@Before
	public void intialize() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
/*		mockEmp = new Employee((long) 101, "ak.ajaykaushik96@gmail.com", "Ajay", "Kaushik");
*/	
		//mockEmp=new Employee(empId, email, firstName, lName)
	
		Employee employee=new Employee();
		employee.setEmail("ajay21@gmail.com");
		employee.setFirstName("Ajay");
		employee.setEmpId(12l);
		employee.setlName("Kaushik");
		emp.add(employee);
		
		
	}

	@Test
	public void getParticularId() throws Exception
	{
		/*MvcResult mvcResult = 
				mockMvc.perform
				(MockMvcRequestBuilders.get("/employee/12").accept(MediaType.APPLICATION_JSON));
		String expectedResults = " {\n" + "        \"empId\": 12,\n" + "        \"email\": \"ajay21@gmail.com\",\n"
				+ "        \"firstName\": \"Ajay\",\n" + "  \"lname\": \"Kau shik\"   }";
		int status=mvcResult.getResponse().getStatus();
		JSONAssert.assertEquals(expectedResults, mvcResult.getResponse().getContentAsString(),false);
		
		*/
		
		
		Mockito.when(empService.getAllEmployees()).thenReturn((emp));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee").accept(MediaType.APPLICATION_JSON);
		
		
		mockMvc.perform(MockMvcRequestBuilders.get("/employee").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
		
		MvcResult mvcResult=mockMvc.perform(requestBuilder).andReturn();		
		String expectedResults = " [{\n" + "        \"empId\": 12,\n" + "        \"email\": \"ajay21@gmail.com\",\n"
						+ "        \"Employee_First_Name\": \"Ajay\",\n" + "        \"lName\": \"Kaushik\"  }]";
		
		System.out.println("Json format======"+mvcResult.getResponse().getContentAsString());
		
		JSONAssert.assertEquals(expectedResults, mvcResult.getResponse().getContentAsString(), false);
				
				
	}

	
	@Test
	public void testpostMethod() throws Exception
	{
	
		
		
		
		String InputJson = "{\n" + "  \"empId\": \"12\",\n" + "  \"email\": \"ajay21@gmail.com\",\n"
				+ "  \"Employee_First_Name\": \"Ajay\",\n" + "  \"lName\": \"Kaushik\"   }]";
		
		
/*		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee").accept(MediaType.APPLICATION_JSON);
*/		
		         mockMvc.perform(MockMvcRequestBuilders.post("/employee")
				.accept(MediaType.APPLICATION_JSON).content(InputJson)).andReturn();
				
		         
		         
		         
		         
		         
		         
		         
		         
		         
/*		MvcResult mvcResult=mockMvc.perform(requestBuilder).andReturn();
	
		MockHttpServletResponse response = mvcResult.getResponse();
		assertEquals(HttpStatus.CREATED.value() ,  response.getStatus());
		assertEquals("http://localhost:8080/employee", response.getHeader(HttpHeaders.LOCATION));*/
		
		
	}

	
	
	@Test
	public void testDeleteMethod() throws Exception
	{
		
		String json = "{\n" + "  \"empId\": \"12\",\n" + "  \"empId\": \"ajay21@gmail.com\",\n"
				+ "  \"Employee_First_Name\": \"Ajay\",\n" + "  \"lName\": \"Kaushik\"   }]";

		

                mockMvc.perform(MockMvcRequestBuilders.delete("/employee").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json)).andReturn();
				
		
}
	
	@Test
	public void testUpdateMethod() throws Exception
	{
         
		
		String InputJson = "{\n" + "  \"empId\": \"13\",\n" + "  \"empId\": \"ajay21@gmail.com\",\n"
				+ "  \"Employee_First_Name\": \"Ajay\",\n" + "  \"lName\": \"Kaushik\"   }]";

		

		mockMvc.perform(MockMvcRequestBuilders.put("/employee").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(InputJson)).andReturn();
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
