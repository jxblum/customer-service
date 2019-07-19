package io.pivotal.crm.customerservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.config.annotation.EnableClusterConfiguration;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;

import io.pivotal.crm.customerservice.model.Customer;
import io.pivotal.crm.customerservice.repo.CustomerRepository;

@SpringBootApplication
@EnableEntityDefinedRegions
@EnableClusterConfiguration(useHttp = true)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	@SuppressWarnings("unused")
	ApplicationRunner runner(CustomerRepository customerRepository) {

		return args -> {

			assertThat(customerRepository.count()).isEqualTo(0);

			Customer jonDoe = Customer.newCustomer(1L, "Jon Doe");

			System.err.printf("Saving Customer [%s]...%n", jonDoe);

			jonDoe = customerRepository.save(jonDoe);

			assertThat(jonDoe).isNotNull();
			assertThat(jonDoe.getId()).isEqualTo(1L);
			assertThat(jonDoe.getName()).isEqualTo("Jon Doe");
			assertThat(customerRepository.count()).isEqualTo(1);

			System.err.println("Querying for Customer [SELECT * FROM /Customers WHERE name LIKE '%Doe']...");

			Customer queriedJonDoe = customerRepository.findByNameLike("%Doe");

			assertThat(queriedJonDoe).isEqualTo(jonDoe);

			System.err.printf("Customer was [%s]%n", queriedJonDoe);
		};
	}
}
