package com.bwf.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bwf.entity.User;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class UserMapperTest {
	@Autowired
	UserMapper userMapper;
	
	Logger logger=LoggerFactory.getLogger(UserMapperTest.class);
	
	@Test
	public void testGetAllUser(){
		Assert.assertEquals(10, userMapper.getAllUserBypage(1, 10).size());
		for( User user : userMapper.getAllUser() ) {
			if ( user.getLeader() != null ) {
				logger.info( user.getLeader().getNickname() );
			}
		}
		
	}
}
