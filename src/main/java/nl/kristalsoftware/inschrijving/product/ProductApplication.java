package nl.kristalsoftware.inschrijving.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@Slf4j
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Bean
	CommandLineRunner seedDatabase(ProductService productService) {
		return args -> {
			log.info("Seed database");
			productService.addProduct("Energiewandeling", new BigDecimal(17.50));
			productService.addProduct("Meditatie", new BigDecimal(20.00));
		};
	}

}

