package it.demo.kafka.springkafka;

import it.demo.kafka.springkafka.bean.Flight;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/kafka-outbound-context.xml")
public class Outbound 
{
	@Autowired
	@Qualifier("inputToKafka")
	MessageChannel channel;
	
	private static final Log LOG = LogFactory.getLog(Outbound.class);
    
	@Test
    public void testAppFlight()
    {
    	LOG.info(channel.getClass());

		//sending 100,000 messages to Kafka server for topic test1
		for (int i = 0; i < 50; i++) {
			final Flight flight = new Flight();
			flight.setNumber("U22552");
			flight.setLatitude(i);
			flight.setLongitude(i+100);
			channel.send(
					MessageBuilder.withPayload(flight)
							.setHeader("topic", flight.getNumber()).build());

			LOG.info("message sent " + i);
		}
      
    }
}
