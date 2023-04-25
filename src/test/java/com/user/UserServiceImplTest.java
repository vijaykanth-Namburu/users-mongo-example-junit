/*package com.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.user.Exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.user.model.User;
import com.user.repository.Repository;
import com.user.service.UserServiceImpl;



@SpringBootTest(classes= {UserServiceImplTest.class})
class UserServiceImplTest {




	@InjectMocks
	private UserServiceImpl service;
	
	@Mock
	private Repository repository;
	
	

	@Test
	void testCreateUser() {
		User user = new User(1,1,"springboot","learning springboot");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user,service.createUser(user));
		}
	
	@Test
	void testCreateListUsers() {
		List<User> us = new ArrayList<>();
		us.add(new User(1,1,"springboot","learning springboot"));
		us.add(new User(2,1,"Java","learning Java"));
		when(repository.saveAll(us)).thenReturn(us);
		assertEquals(us,service.createListUsers(us));
	}
	
	@Test
	void testFindAllUsers() {
		
		List<User> ls1 = new ArrayList<>();
		ls1.add(new User(1,1,"springboot","learning springboot"));
		
		when(repository.saveAll(ls1)).thenReturn(ls1);
		assertEquals(1,1,service.findAllUsers().size());

	}
	
	@Test
	void testDeleteAll() {
		
		doNothing().when(repository).deleteAll();
		service.deleteAll();
	}
	
	@Test
	void testUpdateItem() throws Exception {
		User us =new User(2,1,"java","learning java");
		when(repository.findById(us.getIt())).thenReturn(Optional.of(us));
		when(repository.save(us)).thenReturn(us);
		assertEquals(us,service.updateItem(us, 1));
		
		
		when(repository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		service.updateItem(us, 1);
		

	}
	
	
	
	
	@Test
	void testUpdateListUser() throws Exception {
		
		List<User> us = new ArrayList<>();
		us.add(new User(2,1,"springboot","learning java"));
		us.add(new User(3,3,"boot","learning "));
		us.add(new User(4,4,"spring","learn java"));
		us.add(new User(5,5,"flowers","learn java technology"));
		
		
		List<User> output = new ArrayList<>();
		output.add(new User(2,1,"springboot","learning java"));
		output.add(new User(3,3,"boot","learning "));
		output.add(new User(4,4,"spring","learn java"));
		output.add(new User(5,5,"1800Flowers","1800Flowers"));
		
		
		
		when(repository.saveAll(Mockito.anyList())).thenReturn(output);
		//when(repository.findById(us.getIt())).thenReturn(Optional.of(us));
		//when(repositorusy.save(us)).thenReturn(us);
		service.updateListUser(us);
		
		
		
		
		
		
		
		
		/*user.get(3).setTitle("1800Flowers");
		user.get(3).setBody("1800Flowers");
		repository.saveAll(user);
		return user;
	}

	void testCountUniqueUserId() {
		List<User> user = repository.findAll();
		when(repository.findAll()).thenReturn(user);
		assertEquals(service.countUniqueUserId(), service.countUniqueUserId());
		

	}
	

	void testfindByitem() throws NotFoundException {
		User us = new User(2,1,"springboot","learning java");
		when(repository.findById(us.getIt())).thenReturn(Optional.of(us));
		assertEquals(us,service.findByitem(1));
		
		when(repository.findById(Mockito.anyInt())).thenReturn(Optional.empty());

		service.findByitem(1);
		
		
		
	}
	

}
	
*/
	
/*Optional<User> use =	repository.findById(it);

if(use.isPresent()) {
	return use.get();
}else {
	return null;
}	}*/
	




