package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableBinding(Sink.class)
public class LoggingConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggingConsumerApplication.class, args);
	}
	
	/*@StreamListener(target = Sink.INPUT, condition = "headers['type']=='bogey'")
	public void handle(String person) {
		System.out.println("bogey Received: " + person);
		//return person;
	}
	
	@StreamListener(target = Sink.INPUT, condition = "headers['type']=='bacall'")
	public void handleOUTPUT(String person) {
		System.out.println("bacall Received: " + person);
	}*/
	
	@StreamListener(Sink.INPUT) // destination name 'input.myGroup'
	public void handle(Person value) {
		throw new RuntimeException("BOOM!");
	}

	@ServiceActivator(inputChannel = Processor.INPUT + ".myGroup.errors") //channel name 'input.myGroup.errors'
	public void error(Message<?> message) {
		System.out.println("Handling ERROR: " + message);
	}
	
	

	public static class Person {
		private String sex;
		private String name;
		
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String toString() {
			return this.name;
		}
	}
}
