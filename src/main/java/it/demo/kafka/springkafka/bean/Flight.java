package it.demo.kafka.springkafka.bean;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="flights") 
public class Flight {

	@Id
	private ObjectId _id; 
	private String number;
	private double latitude;
	private double longitude;

	public Flight(){}
	
	public Flight(String number, double latitude, double longitude) {
		this.number = number;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public ObjectId get_id() {
		return _id;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "number = " + number + " latitude = " + latitude + " longitude = " + longitude;
	}
}
