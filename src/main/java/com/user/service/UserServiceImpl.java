package com.user.service;

import java.util.Map;
import java.util.stream.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

import com.user.Exception.NoDataException;
import com.user.Exception.NoitemException;
import com.user.Exception.NotFoundException;

import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.user.model.User;
import com.user.repository.Repository;

@Service
public class UserServiceImpl implements UserService {

	//private static final Logger logger = (Logger) LoggerFactory.getLogger(User.class);

	Logger logger=(Logger) LoggerFactory.getLogger("FirstLogger");


	@Autowired
	private Repository repository;
	
	
	public User createUser(User user) {

		logger.info(" Inside create user");
		return repository.save(user);
	}
	
	public List<User> createListUsers(List<User> user) {

		return repository.saveAll(user);
	}
	
	
	public List<User> findAllUsers(){
		return repository.findAll();
	}
	
	
	public User findByitem(int it) throws NotFoundException {
		logger.info("Finding item with id:"+it);
		return repository.findById(it).orElseThrow(() -> new NotFoundException("item","id",it)) ;

		}
	
	
	public User updateItem(User user) throws NoDataException {

		User us=repository.findById(user.getIt()).orElseThrow(() ->new NoDataException("item", "id", user.getIt()));

			us.setUserid(user.getUserId());
			us.setIt(user.getIt());
			us.setTitle(user.getTitle());
			us.setBody(user.getBody());
			return repository.save(us);
		}

	
	public void deleteAll() {
		 repository.deleteAll();
	}


	public void delete(int it) {
		repository.findById(it);
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
