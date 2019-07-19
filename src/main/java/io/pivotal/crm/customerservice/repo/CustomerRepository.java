package io.pivotal.crm.customerservice.repo;

import org.springframework.data.repository.CrudRepository;

import io.pivotal.crm.customerservice.model.Customer;

/**
 * The CustomerRepository class...
 *
 * @author John Blum
 * @since 1.0.0
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	Customer findByNameLike(String name);

}
