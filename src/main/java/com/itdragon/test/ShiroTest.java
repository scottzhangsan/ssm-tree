package com.itdragon.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class ShiroTest {
	
	@Test
	public void testHelloWold(){
		//1:获取SecurityManager的工厂。
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini") ;
		//2:获取securityManage的实例并绑定给SecurityUtil
		SecurityManager securityManager =factory.getInstance() ;
		
		SecurityUtils.setSecurityManager(securityManager);
		//3:获取subject的实例。创建用户名，密码进行身份验证。
	    Subject subject = SecurityUtils.getSubject() ;
	    
	    UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhang", "123") ;
	    
	    try {//4:登录身份验证
	    	subject.login(usernamePasswordToken);
		} catch (AuthenticationException e) {
			// TODO: handle exception
		}
	    
		Assert.assertEquals(true, subject.isAuthenticated());
		//5：退出
		subject.logout();
	}

}
