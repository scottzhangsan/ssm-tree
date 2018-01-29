package com.itdragon.pojo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
/**
 * mock测试
 * @author zhangyaz
 *
 */
public class PersonServiceTest {
 
	private PersonDao mockDao ;
	
	private PersonService personService ;
	
	@Before
	public void setUp(){
		//创建mock对象。
		mockDao = mock(PersonDao.class) ;
		
		when(mockDao.getPerson(1)).thenReturn(new Person(1, "person1")) ;
		
		when(mockDao.update(isA(Person.class))).thenReturn(true) ;
		
		personService = new PersonService(mockDao) ;
		
	}
	@Test
	public void testUpdate (){
		Person p1 = personService.getPersonById(1) ;
		
		assertTrue(p1.getId()==1);
		boolean result = personService.update(1, "new name") ;
		 assertTrue("must true", result);
		// verify(mockDao,times(1)).getPerson(eq(1));
		 //verify(mockDao,times(1)).update(isA(Person.class)) ;
		
	}
	/*@Test
	public void testUpdateNotFind() throws Exception{
		boolean result  = personService.update(1,"new name") ;
		
		assertTrue("must true", result);
		
		verify(mockDao,timeout(1)).getPerson(eq(1));
		
	   verify(mockDao,never()).update(isA(Person.class));
		
	}*/
}
