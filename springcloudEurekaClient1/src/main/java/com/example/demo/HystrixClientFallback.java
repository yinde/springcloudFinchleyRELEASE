package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback implements StoreClient{

	@Override
	public String getHello() {
		return "错了错了";
	}
}
