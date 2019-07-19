package io.pivotal.crm.customerservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * The Customer class...
 *
 * @author John Blum
 * @since 1.0.0
 */
@Getter
@Region("Customers")
@RequiredArgsConstructor(staticName = "newCustomer")
@ToString(of = "name")
public class Customer {

	@Id @NonNull
	private Long id;

	@NonNull
	private String name;

}
