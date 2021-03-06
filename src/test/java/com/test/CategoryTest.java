package com.test;

import java.util.List;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.itdragon.common.pojo.EUTreeNode;
import com.itdragon.service.CategoryService;

//加载配置文件学习解决冲突111

//加载配置文件学习解决冲突222

@RunWith(SpringJUnit4ClassRunner.class)
//加载配置文件
@ContextConfiguration(locations={"classpath:spring/applicationContext-*.xml","classpath:spring/springmvc.xml"})
public class CategoryTest {
	@Autowired
	private CategoryService categoryService ;
	
	@Test
	public void testCategory(){
		List<EUTreeNode> categories =categoryService.getCategoryList();
		
		Assert.assertNotEquals(categories.size(), 0);
		Assert.assertNotNull(categories);
		
	}
	
	//运用Spring给的接口调用方法。restTemplate
	@Test
	public void testTemplate(){
		//远程调用其他的接口。
		 RestTemplate restTemplate =new RestTemplate() ;
		List<EUTreeNode> list	=restTemplate.getForObject("http://localhost:8080/category/async/", List.class) ;
		Assert.assertNotEquals(list.size(), 0);
		
		List<EUTreeNode> list2 =restTemplate.postForObject("http://localhost:8080/category/sync/", null, List.class) ;
		Assert.assertNotEquals(list2.size(), 0);
	}
 
}
