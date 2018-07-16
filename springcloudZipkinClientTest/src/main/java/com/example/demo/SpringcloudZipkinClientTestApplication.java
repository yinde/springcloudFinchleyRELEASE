package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@SpringBootApplication
public class SpringcloudZipkinClientTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudZipkinClientTestApplication.class, args);
	}
	
	@RequestMapping("/hi")
    public String home(){
        return "hi i'm miya!";
    }

    /*@RequestMapping("/miya")
    public String info(){
        return restTemplate.getForObject("http://localhost:8763/info",String.class);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
	*/
}
