package it.demo.kafka.springkafka;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-config.xml")
public class Inbound 
{
	
	private static final Log LOG = LogFactory.getLog(Inbound.class);
	
	@Test
    public void testApp() throws IOException
    {
    	LOG.info("Started");
    	System.in.read();
    	LOG.info("Stopped");
      
    }
}
