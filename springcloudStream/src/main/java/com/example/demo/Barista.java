package com.example.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Barista {

	String orders = "orders";
	
	String hotDrinks="hotDrinks";
	
    @Input(Barista.orders)
    SubscribableChannel orders();

    @Output(Barista.hotDrinks)
    MessageChannel hotDrinks();

    @Output
    MessageChannel coldDrinks();
}
