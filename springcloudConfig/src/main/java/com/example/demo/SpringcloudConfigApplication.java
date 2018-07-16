package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableConfigServer
@RestController
@SpringBootApplication
public class SpringcloudConfigApplication {

	@Value("${server.port}")
	private String serverport;
	
	@RequestMapping("/")
    public String home() {
        return "Hello world client "+serverport;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SpringcloudConfigApplication.class, args);
	}
}
