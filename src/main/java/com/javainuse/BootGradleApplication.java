package com.javainuse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.javainuse.java.CustomerRepository;
import com.javainuse.java.User;

@SpringBootApplication
public class BootGradleApplication {

	private static final Logger log = LoggerFactory.getLogger(BootGradleApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BootGradleApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new User(1,"Jack", "Bauer"));
			repository.save(new User(2,"Chloe", "O'Brian"));
			repository.save(new User(3,"Kim", "Bauer"));
			repository.save(new User(4,"David", "Palmer"));
			repository.save(new User(5,"Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (User customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			repository.findById((int) 1L)
				.ifPresent(user -> {
					log.info("User found with findById(1L):");
					log.info("--------------------------------");
					log.info(user.toString());
					log.info("");
				});

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}
	
}