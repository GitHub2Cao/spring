package com.softnovo.base;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.qos.logback.core.joran.spi.JoranException;

@RunWith(SpringJUnit4ClassRunner.class)

//告诉junit spring配置文件
@ContextConfiguration({
    "classpath:spring/spring-dao.xml",
    "classpath:spring/spring-service.xml"})
public class ServiceBaseTest {
	@Before
	public void initLogback() throws IOException, JoranException {
//		LogBackConfigLoader.load("/Users/cgm/newgit/spring/src/main/resources/spring/logback.xml");
//	    org.slf4j.Logger logger = LoggerFactory.getLogger("com.softnovo.base");  
//	    logger.debug("logback inited");
		
		System.out.println("----------start time-------- " + System.currentTimeMillis());
	}
	
	@After
	public void end() {
		
	}
	
	
}
