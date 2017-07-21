package com.ssm.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ssm.dto.PageBean;
import com.ssm.dto.User;
import com.ssm.service.IUserService;



public class TestMybatis {
	
	final Logger logger = LoggerFactory.getLogger(getClass());
	
    private ApplicationContext ac = null;
    @Resource
    private IUserService userService = null;

    @Before
    public void before() {
        ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        userService =  (IUserService) ac.getBean("userService");
    }

    @Test
    public void testinsertSelective(){  
       
    	Integer count = userService.getUserCount("xiao");
    	
    	User user = new User();
    	user.setAge(25);
    	user.setName("哈哈1");
    	user.setPassword("bbb");
    	
    	User user2 = new User();
    	user2.setAge(21);
    	user2.setName("合格1");
    	user2.setPassword("3333");
    	
    	List<User> list = new ArrayList<>();
    	list.add(user);
    	list.add(user2);
    	
    	userService.insertUserByBatch(list);
    	
    	System.out.println(count);
    }
    @Test
    public void testselectByPrimaryKey(){
        int id = 1;
        User user = userService.getUserById(1);
        System.out.println(user.toString());

    }
    
    
    @Test
    public void testselectUserList(){
    	logger.info("111");
    	PageBean<User> page = userService.findByPage(1); 
    	List<User> userList = page.getLists();
    	for (User user : userList) {
    		System.out.println(user.getName());
		}
    }
}