package com.dealshark.testing;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.dealshark.model.User;
import com.dealshark.repository.UserRepositoryImpl;
 

public class UserRepositoryTest {
	
	
	  @Test
	    public void testFirstName() {
	        User myUser = new User();
	        
	        

	        myUser.setFirstName("Howdy");
	        

	        assertEquals("Howdy", myUser.getFirstName());

	    }
	  
	  @Test
	    public void testLastName() {
	        User myUser = new User();
	        
	        

	        myUser.setLastName("Howdy");
	        

	        assertEquals("Howdy", myUser.getLastName());

	    }
	  
	  @Test
	    public void testUsername() {
	        User myUser = new User();
	        
	        

	        myUser.setUsername("Howdy");
	        

	        assertEquals("Howdy", myUser.getUsername());

	    }
	  
	  
	  @Test
	    public void testPassword() {
	        User myUser = new User();
	        
	        

	        myUser.setPassword("Howdy");
	        

	        assertEquals("Howdy", myUser.getPassword());

	    }
	  
	  
	  
	  @Test
	    public void testId() {
	        User myUser = new User();
	        
	        

	        myUser.setId(2);
	        

	        assertEquals(2, myUser.getId());

	    }
	  
	  
	  
	  @Test
	    public void testBalance() {
	        User myUser = new User();
	        
	        

	        myUser.setBalance(200);
	        

	        assertEquals(200, myUser.getBalance());

	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
