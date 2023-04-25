package com.user.controller;

import java.util.List;

import com.user.Exception.NoDataException;
import com.user.Exception.NoitemException;
import com.user.Exception.NotFoundException;
import com.user.repository.Repository;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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


@RestController
public class Controller {
	
	@Autowired
	UserService service;
	@Autowired
	private Repository repository;

	@PostMapping("/create")
	    public User createUser(@RequestBody User user) throws NoDataException {

			return service.createUser(user);

	}
	 	
	 	@PostMapping("/createAll")
	    public List<User> createUsers(@RequestBody List<User> user) {
	    		
	    		return service.createListUsers(user);
	    }
	 	
	 	
	 	 @PutMapping("/update/{it}")
	     public User Updateitem(@PathVariable("it") int it,@RequestBody User user) throws NoDataException, NoitemException {
		     user.setIt(it);
			 return service.updateItem(user);

		 }


			 /*try {
				 User us1 =service.updateItem(user, it);
			 } catch (Exception e) {
				 throw new RuntimeException(e);
			 }
			 return new ResponseEntity<>("Updated it  Successfully", HttpStatus.CREATED);*/



	 	 
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


		 @DeleteMapping("/delete/{it}")
		 public ResponseEntity<?> deleteUser(@PathVariable("it")  int it) throws NotFoundException{
			 User us = repository.findById(it).orElseThrow(() -> new NotFoundException("item","id",it));
			 repository.delete(us);
			 return ResponseEntity.ok().build();

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


