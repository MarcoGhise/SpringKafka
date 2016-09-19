package it.demo.kafka.springkafka.activator;

import it.demo.kafka.springkafka.bean.Flight;
import it.demo.kafka.springkafka.dao.MongoDao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessor {

	@Autowired
	MongoDao dao;
	
	@SuppressWarnings("unchecked")
	@ServiceActivator
    public <K, V> void processPayment(Map<K, V> payload) {
 
		/*
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500); 
		
		double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum + cost).get(); 
		*/
		
		String key = null;
		//access via new for-loop
		for(K item : payload.keySet()) {
			key = (String) item;
		}
				
		Map<K, V> topic = (Map<K, V>)payload.get(key);
		
		List<Flight> order = (List<Flight>)topic.get(0);
		
		order.forEach((v) -> dao.insertFlight(v));
    }
}
