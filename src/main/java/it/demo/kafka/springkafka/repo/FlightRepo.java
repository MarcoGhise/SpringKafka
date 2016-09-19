package it.demo.kafka.springkafka.repo;

import java.util.List;

import it.demo.kafka.springkafka.bean.Flight;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends CrudRepository<Flight, String>{
	List<Flight> findByNumber(String number);

}
