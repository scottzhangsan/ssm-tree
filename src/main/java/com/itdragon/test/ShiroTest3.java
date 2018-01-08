package com.itdragon.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ShiroTest3 extends BaseTest {
        
	
	@Test
	public void testHasRole(){
		login("classpath:shiro-role.ini","zhang", "123");
		//判断拥有role1
		Assert.assertTrue(subject().hasRole("role1"));
		//判断拥有role1,role2,
		Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1","role2")));
		
		boolean [] result = subject().hasRoles(Arrays.asList("role1","role2","role3")) ;
		//拥有角色1
		Assert.assertEquals(true, result[0]);
		//拥有角色2
		Assert.assertEquals(true, result[1]);
		//没有角色3
		Assert.assertEquals(false, result[2]);
		
	}
}
