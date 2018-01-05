package com.test;

import java.util.List;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
import com.itdragon.common.pojo.EUTreeNode;
import com.itdragon.service.CategoryService;
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
 
}
