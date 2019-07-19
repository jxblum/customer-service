package io.pivotal.crm.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.crm.customerservice.model.Customer;
import io.pivotal.crm.customerservice.repo.CustomerRepository;

/**
 * The CustomerController class...
 *
 * @author John Blum
 * @since 1.0.0
 */
@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/")
	public String hello() {
		return ping();
	}

	@GetMapping("/ping")
	public String ping() {
		return "<H1>PONG</H1>";
	}

	@GetMapping("/customers/{id}")
	public Customer get(@PathVariable("id") Long id) {
		return this.customerRepository.findById(id).orElse(null);
	}
}
