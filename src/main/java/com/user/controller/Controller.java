package com.user.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.user.Exception.NoDataException;
import com.user.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.NonTransientDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister;
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
	    public ResponseEntity<?> createUser(@RequestBody User user) throws NoDataException {

			User us = service.createUser(user);
			if (us!=null){
				return new ResponseEntity<>("created Successfully", HttpStatus.CREATED);
			}
			else{
				throw new NoDataException("Empty Data");
			}
		}
	 	
	 	@PostMapping("/createAll")
	    public List<User> createUsers(@RequestBody List<User> user) {
	    		
	    		return service.createListUsers(user);
	    }
	 	
	 	
	 	 @PutMapping("/update/{it}")
	     public ResponseEntity<?> Updateitem(@PathVariable("it") int it,@RequestBody User user) throws Exception  {
	    User us1 =service.updateItem(user, it);
		if(us1 != null){
			return new ResponseEntity<>("Updated it  Successfully", HttpStatus.CREATED);
		}
		else{
			throw new NoDataException("provide it");

		}
	 	 }
	 	 
	 	 @GetMapping("/findAll")
	     public List<User> getAllUsers() 
	     {
	 		 return service.findAllUsers();
	     }
	     
	     @GetMapping("/findByIt/{it}")
	     public User getitemIt(@PathVariable("it") int it) throws NotFoundException {
	    	 return service.findByitem(it);
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
	     
	   
	     
	     
	     
	     
	     
	     
	     
	     /*  @PutMapping("/updateListuser")
	     public List<User> updateUser(@RequestBody List<User> user)
	                                                     throws Exception {
	 	  List<User> update1 = service.updateListUser(user);
	       return update1; 
	   
	     }*/
}


