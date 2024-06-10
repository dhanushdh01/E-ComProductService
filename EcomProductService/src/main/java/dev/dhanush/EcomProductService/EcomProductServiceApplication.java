package dev.dhanush.EcomProductService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EcomProductServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(EcomProductServiceApplication.class, args);
	}

}
