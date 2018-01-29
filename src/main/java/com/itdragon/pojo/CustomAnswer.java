package com.itdragon.pojo;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class CustomAnswer implements Answer<String> {
/**
 * 这个返回值是这样的逻辑，如果调用mock某个方法输入的参数大于3，则返回“yes”
 * 
 * 否则抛出异常。
 */
	public String answer(InvocationOnMock invocation) throws Throwable {
		Object[] args = invocation.getArguments() ;
		Integer num =(Integer)args[0];
		
		if (num>3) {
			return "yes";
		}else{
			throw new RuntimeException() ;
		}
		
	}

}
