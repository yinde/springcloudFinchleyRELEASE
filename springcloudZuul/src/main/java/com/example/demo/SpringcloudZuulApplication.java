package com.example.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableZuulProxy
@SpringBootApplication
@RefreshScope
public class SpringcloudZuulApplication {

	@Value("${server.port}")
	private String serverport;
	
	@GetMapping("/")
    public String home() {
        return "Hello world zuul"+serverport;
    }
	
	@GetMapping("/home")
    public String home1() {
        return "Hello world zuul home1 "+serverport;
    }
	
	@GetMapping("/home/client")
    public String homeclient() {
        return "Hello world zuul homeclient "+serverport;
    }
	
	@GetMapping("/client")
    public String client() {
        return "Hello world zuul client "+serverport;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SpringcloudZuulApplication.class, args);
	}
}
