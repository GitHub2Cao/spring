package com.softnovo.base;

import java.io.IOException;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.qos.logback.core.joran.spi.JoranException;

@RunWith(SpringJUnit4ClassRunner.class)

//告诉junit spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class DaoBaseTest {
	@Before
	public void initLogback() throws IOException, JoranException {
		//oooooooooookkkk
//		ResourceLoader loader = new DefaultResourceLoader();
//		Resource resource = loader.getResource("classpath:spring/logback.xml");
//		LogBackConfigLoader.loadWithResource(resource);
		
		
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource resource = resolver.getResource("classpath:spring/logback.xml");
		
		LogBackConfigLoader.loadWithResource(resource);
	    org.slf4j.Logger logger = LoggerFactory.getLogger("com.softnovo.base");
	    logger.debug("logback inited"); 
	}
}
