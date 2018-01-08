package com.itdragon.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class MyRealm2 implements Realm{

	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//得到用户名
		String userName = (String)token.getPrincipal() ;
		//得到用户密码。token.getCredentials()得到的是一个char数组
		String password = new String((char[])token.getCredentials());
		
		if(!("zhang".equals(userName))){
			throw new UnknownAccountException() ; //用户名错误
		}
		
		if(! "123".equals(password)){
			throw new IncorrectCredentialsException() ;
		}
		return new SimpleAuthenticationInfo(userName, password,getName());
	}

	public String getName() {
		
		return "myrealm";
	}

	public boolean supports(AuthenticationToken token) {
		
		return token instanceof UsernamePasswordToken;
	}

}
