package com.user.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.user.model.User;
import com.user.repository.Repository;
import com.user.service.UserServiceImpl;




@ComponentScan(basePackages = "com.user")
@ContextConfiguration
@AutoConfigureMockMvc
@SpringBootTest(classes= {ControllerTest.class})
class ControllerTest {

	
	
	@Autowired
	MockMvc mockmvc;
	
	@Mock
	private Repository repository;
	
	
	@Mock
	private UserServiceImpl service;
	
	@InjectMocks
	private Controller controller;
	
	@Autowired
	private ObjectMapper mapper;
	
	
	@BeforeEach
	public void setup()
	{
		mockmvc =MockMvcBuilders.standaloneSetup(controller).build();
		
	}
	
	/*@Test
	void testCreateUser() throws JsonProcessingException, Exception {
		User us = new User(2,1,"Ioc container","learning springboot");
		
		when(service.createUser(Mockito.any(User.class))).thenReturn(us);
		this.mockmvc.perform(post("/create")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
	   			.content(mapper.writeValueAsString(us)))
	   			.andExpect(status().isOk())
	   			.andDo(print());
	   			
	}*/
	
	@Test
	void testCreateUsers() throws JsonProcessingException, Exception {
		ArrayList<User> us= new ArrayList<>();
		us.add(new User(2,1,"Ioc container","learning springboot") );
		
		when(service.createListUsers((List<User>) Mockito.any(User.class))).thenReturn(us);
		this.mockmvc.perform(post("/createAll")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
	   			.content(mapper.writeValueAsString(us)))
	   			.andExpect(status().isOk())
	   			.andDo(print());	
		
	}
	
	@Test
	void testGetAllUsers() throws Exception {
		List<User> us = new ArrayList<User>();
		us.add(new User(2,1,"Ioc container","learning springboot") );

		when(service.findAllUsers()).thenReturn(us);
		this.mockmvc.perform(get("/findAll"))
					.andExpect(status().isOk())
					.andDo(print());
	}
	
	@Test
	void testGetitemIt() throws Exception {
		User us = new User(2,1,"Dependency Injection","learning springboot");
		
		when(service.findByitem(Mockito.anyInt())).thenReturn(us);
		this.mockmvc.perform(get("/findByIt/{it}",1))
					.andExpect(status().isOk())
					.andExpect(MockMvcResultMatchers.jsonPath(".userId").value(2))

					.andExpect(MockMvcResultMatchers.jsonPath(".it").value(1))

					.andExpect(MockMvcResultMatchers.jsonPath(".title").value("Dependency Injection"))
					.andExpect(MockMvcResultMatchers.jsonPath(".body").value("learning springboot"))
					.andDo(print());
		}
	
	/*@Test
	void testUpdateitem() throws JsonProcessingException, Exception {
		User us = new User(2,1,"Dependency Injection","learning springboot");
		   when(service.updateItem(Mockito.any(User.class),Mockito.anyInt())).thenReturn(us);
		   this.mockmvc.perform(((MockHttpServletRequestBuilder) put("/update/{customerId}",1))
				   		.contentType(MediaType.APPLICATION_JSON_UTF8)
				   		.content(mapper.writeValueAsString(us)))
		   				.andExpect(status().isOk())
		   				.andExpect(jsonPath("$.userId", is(us.getUserId())))
		   				.andExpect(jsonPath("$.it", is(us.getIt())))
		   				.andExpect(jsonPath("$.title", is(us.getTitle())))
		   				.andExpect(jsonPath("$.body").value(us.getBody()))
		   				.andDo(print());

	}*/
	

	/*@Test
	void testDeleteusers()  throws Exception  {
		User us = new User(2,1,"Dependency Injection","learning springboot");
         controller.deleteusers();
     }*/
	

	@Test
	void testDeleteusers() throws Exception  {
		
		doNothing().when(repository).deleteAll();
		controller.deleteusers();
		
		
     }
	
	
	


	@Test
    void testgetuniqueuser() throws JsonMappingException, JsonProcessingException {
		/*List<User> user = service.findAllUsers();
		when(service.findAllUsers()).thenReturn(user);
		this.mockmvc.perform(get("/countuniqueuserids"))
		
		
		return null;*/
		 JsonNode node = new ObjectMapper().createObjectNode();
		  ((ObjectNode)node).set("unique userid:",new ObjectMapper().readTree("0"));
			
		  assertEquals(node,controller.getuniqueuser());
		
		/*String count =service.countUniqueUserId().toString();
   	 

   	 JsonNode node = new ObjectMapper().createObjectNode();
		return ((ObjectNode)node).set("unique userid:",new ObjectMapper().readTree(count));*/
		

	}
}





	
