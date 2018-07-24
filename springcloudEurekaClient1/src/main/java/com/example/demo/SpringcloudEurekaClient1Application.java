package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@SpringBootApplication
@RestController
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@RefreshScope
public class SpringcloudEurekaClient1Application {
	
	
	@Value("${server.port}")
	private String serverport;
	
	@Autowired
	StoreClient storeClient;
	
	
	
	/*@Autowired
    private LoadBalancerExchangeFilterFunction lbFunction;

	 @Bean
	    public WebClient webClient() {
	        return WebClient.builder().baseUrl("http://client")
	                .filter(lbFunction)
	                .build();
	    }
	
	 @GetMapping("/trace-a")
	    public Mono<String> trace() {
	        System.out.println("===call trace-a===");

	        return webClient().get()
	                .uri("/")
	                .retrieve()
	                .bodyToMono(String.class);
	    }*/
	 
	@GetMapping("/home")
    public Object home() {
		return storeClient.getHello();
    }
	
	@GetMapping("/home/client")
    public Object homeclient() {
		return "/home/client client1";
    }
	
	@GetMapping("/tt")
    public Object tt() {
		return "tt client1";
    }
	
	@GetMapping("/")
    public Object homepage(@RequestHeader(required=false) String uu) {
		System.out.println(uu);
		return "Hello world client1 "+serverport;
    }
	public static void main(String[] args) {
		SpringApplication.run(SpringcloudEurekaClient1Application.class, args);
	}
	
	@Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
