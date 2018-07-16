package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="client",fallback = HystrixClientFallback.class)
public interface StoreClient {

	@RequestMapping(method = RequestMethod.GET, value = "/")
    String getHello();
	
}
