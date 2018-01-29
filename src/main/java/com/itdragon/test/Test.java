package com.itdragon.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Test {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault() ;
		
		String url = "http://localhost:8080/ssm-crud/emps" ;
		
		HttpGet get = new HttpGet(url) ;
		
		CloseableHttpResponse resp = httpClient.execute(get);
		
		resp.getEntity() ;
		
		System.out.println("-------");
		
	}
}
