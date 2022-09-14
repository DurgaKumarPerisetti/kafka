package com.kafka.demo;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerDemo {

	private static final Logger log = LoggerFactory.getLogger(ProducerDemo.class);

	public static void main(String[] args) {
		log.info("Hellow World From Loggers");

		// Create Producer Properties
		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.137.1:9092");
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		// Create Producer
		KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

		// Create a Producer Record - i.e. the data to send to Kafka Producer
		ProducerRecord<String, String> record = new ProducerRecord<>("demo_java", "Hellow World From Kafka");

		// Send the Data
		producer.send(record);

		// Flush and Close the Producer
		producer.flush();
		producer.close();

	}

}
