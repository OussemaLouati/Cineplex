package tn.enu.enit.eureukaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EureukaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EureukaServiceApplication.class, args);
	}

}
