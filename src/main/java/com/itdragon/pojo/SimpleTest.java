package com.itdragon.pojo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.ListDataListener;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;
public class SimpleTest {
	
	
	/**
	 * 对方法设定返回值。
	 * 
	 * when(i.next()).thenReturn("Hello") ;
	 * 
	 * 对方法设定返回异常。
	 * when(i.next()).thenThrow(new RuntimeException());
	 * 对void方法进行预期的设定。
	 * void 方法的模拟不支持when(mock.someMethod()).thenReturn(value)这样的
	 * 语法只支持下面的方式。
	 * 
	 * doNothing().when(i).remove();
	 * 
	 * doThrow(new RuntimeException()).when(i).remove ;
	 * 
	 * 迭代的风格。
	 * 
	 * doNothing().doThrow(new RuntimeException()).when(i).remove();
	 * 第一次调用remove方法什么都不做，第二次调用抛出RuntimeException().
	 */
	@Test
	public void simpleTest(){
		//创建mock对象。
		Iterator i = mock(Iterator.class) ;
		//设置方法
		when(i.next()).thenReturn("Hello").thenReturn("world") ;
		//mock对象创建，可以对类和接口进行mock对象的创建。
		
		String result = i.next() + " " + i.next() ;
		//mock对象的期望行为和返回值的设定。
		verify(i,times(2)).next() ;
		//我们已经了解到可以通过when(mock.someMethod()).thenReturn(value)来
		//设定mock对象的某个方法调用时的返回值，但是也同样有限制对于static和final
		//修饰的方法是无法进行设定的
		Assert.assertEquals("Hello world", result);
	}
	/**
	 * 列子中使用内键的参数的匹配器
	 * 
	 * 首先mock了list的接口，然后迭代的方式模拟了get方法的返回值，
	 * 
	 * 这里利用anyInt（）参数来匹配任何int类型的参数，
	 * 
	 * 如果使用了参数的匹配器，那么所有的参数都需要匹配器来提供，否则将会报错。
	 */
	@Test
	public void argumentMatchersTest(){
		
		List<String> mock = mock(List.class);	
		
		when(mock.get(anyInt())).thenReturn("Hello").thenReturn("World");
		
		String result = mock.get(100)+" "+mock.get(200) ;
		
		verify(mock,times(2)).get(anyInt());
		
		Assert.assertEquals("Hello World", result);
		
	}
	
	/**
	 * 我们已经熟悉了使用verify(mock).someMethod(..)来验证方法
	 * 
	 * 的调用，列子我们mock了list的接口，然后调用了mock对象的一些方法
	 * 
	 * verify的方法调用不关心是否模拟了get(2)方法的返回值，只关心mock对象
	 * 后是否执行了mock.get(2),如果没有执行，测试的方法将不会通过。
	 */
	@Test
	public void verifyTestTest(){
		List<String> mock = mock(List.class) ;
		
		List<String> mock2 = mock(List.class) ;
		
		when(mock.get(0)).thenReturn("hello") ;
		
		mock.get(0);
		
		mock.get(1);
		
		mock.get(2);
		
		mock2.get(0);
		
		verify(mock).get(2) ;
		
		verify(mock,never()).get(3) ;
		
		verifyNoMoreInteractions(mock);
		
		verifyNoMoreInteractions(mock2);
	}

	
	@Test
	public void testAnswer(){
		//首先对list的接口进行mock
		
		List<String> mock = mock(List.class) ;
		
		//指定方法的返回处理类CustomAnswer,因为参数为4大于3所以返回
		//字符串yes
		when(mock.get(4)).thenAnswer(new CustomAnswer()) ;
		
		//对void的方法也可以指定Answer来进行返回处理如
		
		doAnswer(new CustomAnswer()).when(mock).clear();
	}
	
	/**spy对象的监视，mock对象只能调用它的stubbed的方法。调用不了
	 * 它的真实的方法，但可以监视一个真实的对象，这时候对它进行方法的调用
	 * 将调用它的真实的方法，
	 * 
	 */
	@Test
	public void testSpy(){
		List spy =spy(new LinkedList()) ;
		
		when(spy.size()).thenReturn(100) ;
		
		// using the spy calls real methods
		
		spy.add("once");
		
		spy.add("two");
	}
}
