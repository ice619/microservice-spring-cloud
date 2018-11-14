package com.cp.cloud.zipkinservicehi;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ZipkinServiceHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServiceHiApplication.class, args);
	}

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@RequestMapping("/hi")
	public String callHome(){
		System.out.println("calling trace zipkin-service-hi");
		return restTemplate.getForObject("http://localhost:8989/maoqiu", String.class);
	}

	@RequestMapping("/info")
	public String info(){
		System.out.println("calling trace zipkin-service-hi");
		return "I am zipkin-service-hi";
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
