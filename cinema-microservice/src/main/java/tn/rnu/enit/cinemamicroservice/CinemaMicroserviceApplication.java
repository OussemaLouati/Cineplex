package tn.rnu.enit.cinemamicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;


@EnableEurekaClient
@SpringBootApplication
public class CinemaMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaMicroserviceApplication.class, args);
	}
}

@Configuration
class RestTemplateConfig {

	@Primary
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
