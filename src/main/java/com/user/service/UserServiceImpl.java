package com.user.service;

import java.util.Map;
import java.util.stream.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.client.model.Collation;
import com.user.model.User;
import com.user.repository.Repository;

@Service
public class UserServiceImpl {
	
	@Autowired
	private Repository repository;
	
	
	public User createUser(User user) {
		return repository.save(user);
	}
	
	public List<User> createListUsers(List<User> user) {

		return repository.saveAll(user);
	}
	
	
	public List<User> findAllUsers(){
		return repository.findAll();
	}
	
	
	public User findByitem(int it) {
		Optional<User> use =	repository.findById(it);

		if(use.isPresent()) {
			return use.get();
		}else {
			return null;
		}	}
	
	
	public User updateItem(User user,int it) throws Exception {
		Optional<User> us=repository.findById(user.getIt());
		if(us.isPresent())
		{
			User user1 =us.get();
			user1.setUserid(user.getUserId());
			user1.setIt(user.getIt());
			user1.setTitle(user.getTitle());
			user1.setBody(user.getBody());
			return repository.save(user1);
		}else {
			
			return null;
		}
		
	}
	
	public void deleteAll() {
		 repository.deleteAll();
	}
	
	public long countUniqueUsers(List<User> user) {
		return repository.count();
		
		
		//return (List<User>) user.stream()
						//.map(count ->count.getUserId())
						//.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
					
		
		
		
		
		
		/*.collect(Collectors
					.groupingBy(count ->count.getUserId(),Collectors.counting()));*/
		
	
	}
	
	
	
	public Long countUniqueUserId() {
		
		
		List<User> user =repository.findAll();
		
		
		return 	user.stream().filter(distinctByKey(p -> p.getUserId())).collect(Collectors.counting());
		


	}
	
	public List<User> updateListUser(List<User> user) throws Exception {
		
		user.get(3).setTitle("1800Flowers");
		user.get(3).setBody("1800Flowers");
		repository.saveAll(user);
		return user;

	}
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static <T> Predicate<T> distinctByKey(
		    Function<? super T, ?> keyExtractor) {
		  
		    Map<Object, Boolean> seen = new ConcurrentHashMap<>(); 
		    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null; 
		}

	
}
