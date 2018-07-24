package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
@RestController
@RefreshScope
public class SpringcloudEurekaClientApplication {

	@Value("${server.port}")
	private String serverport;
	
	@Value("${aa.bb}")
	private String aabb;
	
	@GetMapping("/test")
    public Object test() {
		return aabb;
    }
	
	
	@RequestMapping("/")
    public String home() {
        return "Hello world client "+serverport;
    }

	@RequestMapping("/home/client")
    public Object homeclient() {
		return "/home/client client";
    }
	
	@RequestMapping("/second")
    public Object second() {
		return "second client";
    }
	
	@RequestMapping("/second/third")
    public Object third() {
		return "third client";
    }
	
	@RequestMapping("/tt")
    public Object thirdfoo() {
		return "thirdfoo client";
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SpringcloudEurekaClientApplication.class, args);
	}
}
