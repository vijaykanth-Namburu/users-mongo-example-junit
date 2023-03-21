package com.user.controller;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.NonTransientDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.user.model.User;
import com.user.repository.Repository;
import com.user.service.UserServiceImpl;


@RestController
public class Controller {
	
	@Autowired
	UserServiceImpl service;
	
	 	@PostMapping("/create")
	    public User createUser(@RequestBody User user) {
	    		
	    		return service.createUser(user);
	    }
	 	
	 	@PostMapping("/createAll")
	    public List<User> createUsers(@RequestBody List<User> user) {
	    		
	    		return service.createListUsers(user);
	    }
	 	
	 	
	 	 @PutMapping("/update/{it}")
	     public User Updateitem(@PathVariable("it") int it,@RequestBody User user) throws Exception  {
	    return service.updateItem(user, it);
	 	 }
	 	 
	 	 @GetMapping("/findAll")
	     public List<User> getAllUsers() 
	     {
	 		 return service.findAllUsers();
	     }
	     
	     @GetMapping("/findByIt/{it}")
	     public User getitemIt(@PathVariable("it") int it) {
	    	 return service.findByitem(it);
	     }
	     
	     @GetMapping("/count")
	     public long getuniqueusers(){
	    	 return service.countUniqueUsers(getAllUsers());
	     }
	     
	     @DeleteMapping("/deleteAll")
	     public void deleteusers() throws Exception {
	    	 service.deleteAll();
	     }
	     
	     @GetMapping("/countuniqueuserids")
	     public JsonNode getuniqueuser() throws JsonMappingException, JsonProcessingException{
	    	 
	    	 String count =service.countUniqueUserId().toString();
	    	 
		
	    	 JsonNode node = new ObjectMapper().createObjectNode();
			return ((ObjectNode)node).set("unique userid:",new ObjectMapper().readTree(count));
			

	     }
	     
	     @PutMapping("/updateListuser")
	     public List<User> updateUser(@RequestBody List<User> user)
	                                                     throws Exception {
	 	  List<User> update1 = service.updateListUser(user);
	       return update1; 
	   
	     	 }
}


