package com.itdragon.pojo;
import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.mockito.InOrder;
public class MockTest {
	
	
	@Test
	public void testList(){
		
		List mockedList = mock(List.class) ;
		//using mock objec
		mockedList.add("one") ;
		
		mockedList.clear(); 
		
		//verification
		
		verify(mockedList).add("one") ;
		
		verify(mockedList).clear(); 
		
	}
	
	@Test
	public void test2List(){
		
		LinkedList mockedList = mock(LinkedList.class) ;
		
		when(mockedList.get(0)).thenReturn("first") ;
		
		when(mockedList.get(1)).thenThrow(new RuntimeException()) ;
		
		System.out.println(mockedList.get(0));
		
		//System.out.println(mockedList.get(1));
		
		System.out.println(mockedList.get(99));
		
		verify(mockedList).get(0) ;
	}
	
	@Test
	public void test3List(){
		LinkedList mockedList = mock(LinkedList.class) ;
		//任何值都返回element的对象。
		when(mockedList.get(anyInt())).thenReturn("element") ;
		
		System.out.println(mockedList.get(999));
	}
	
	@Test
	public void test4List(){
		LinkedList mockedList = mock(LinkedList.class) ;
		
		mockedList.add("once");
		
		mockedList.add("twice");
		
		mockedList.add("twice");
		
		mockedList.add("three times");
		
		mockedList.add("three times");
		
		mockedList.add("three times") ;
		
		verify(mockedList).add("once");
		
		verify(mockedList,times(1)).add("once") ;
		
		verify(mockedList,times(2)).add("twice");
		
		verify(mockedList,times(3)).add("three times") ;
	}
    
	/*@Test
	public void test5List(){
		LinkedList mockedList = mock(LinkedList.class) ;
		
		doThrow(new RuntimeException()).when(mockedList).clear(); 
		
		mockedList.clear();
	}*/
	
	@Test
	public void test6List(){
		
		List singleMock = mock(List.class) ;
		
		singleMock.add("was added first") ;
		
		singleMock.add("was added second") ;
		
		InOrder inOrder = inOrder(singleMock) ;
		
		inOrder.verify(singleMock).add("was added first");
		
		inOrder.verify(singleMock).add("was added second") ;
		
	}
}
