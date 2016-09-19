package it.demo.kafka.springkafka.dao;


import org.springframework.data.mongodb.core.MongoTemplate;
import it.demo.kafka.springkafka.bean.Flight;

public class MongoDao {

	private MongoTemplate mongoTemplate;

	private static final String FLIGHTS = "flights";

	public void insertFlight(Flight flight) {

		if (!getMongoTemplate().collectionExists(FLIGHTS)) {
			getMongoTemplate().createCollection(FLIGHTS);
		}

		getMongoTemplate().insert(flight, FLIGHTS);
	}


	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
}
