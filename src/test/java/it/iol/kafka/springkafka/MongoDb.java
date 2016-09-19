package it.demo.kafka.springkafka;

import it.demo.kafka.springkafka.bean.Flight;
import it.demo.kafka.springkafka.dao.MongoDao;
import it.demo.kafka.springkafka.repo.FlightRepo;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/kafka-dao.xml")
public class MongoDb 
{
	@Autowired
	MongoDao dao;
	
	@Autowired
	FlightRepo repository;
	
	private static final Log LOG = LogFactory.getLog(MongoDb.class);
	
	@Test
    public void testApp() throws IOException
    {
	
		Flight test = new Flight();
		
		String number = RandomStringUtils.randomAlphanumeric(5);
		test.setNumber(number);
		test.setLatitude(Integer.valueOf(RandomStringUtils.randomNumeric(5)));
		test.setLongitude(Integer.valueOf(RandomStringUtils.randomNumeric(5)));

		test = repository.save(test);
		
//		dao.insertFlight(test);
		
		List<Flight> flight = repository.findByNumber("j3pwn");
		
		Iterable<Flight> flights = repository.findAll();
		
		
		flight.forEach(f -> System.out.println(f));
		
		flights.forEach(f -> System.out.println(f));

      
    }
}
