package jretana.basketmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BasketMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasketMicroserviceApplication.class, args);
	}

}
