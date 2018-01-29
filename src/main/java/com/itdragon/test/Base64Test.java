package com.itdragon.test;

import org.apache.shiro.codec.Base64;
import org.junit.Assert;
import org.junit.Test;

public class Base64Test {
	
	@Test
	public void testBase(){
		String str = "hello" ;
		//加密
		String base64Encoding = Base64.encodeToString(str.getBytes()) ;
		//解密
		String str2 =Base64.decodeToString(base64Encoding) ;
		
		Assert.assertTrue(str.equals(str2));
		
		
		
	}

}
