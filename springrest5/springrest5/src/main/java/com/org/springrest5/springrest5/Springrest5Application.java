package com.org.springrest5.springrest5;

import com.org.springrest5.springrest5.model.Customer;
import com.org.springrest5.springrest5.model.CustomerDetails;
import com.org.springrest5.springrest5.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springrest5Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Springrest5Application.class, args);
	}

	@Autowired
    private CustomerRepository customerRepo;

    @Override
    public void run(String...args) throws Exception {

        Customer cust = new Customer("Gokul", "Jaeger", "gokul@gmail.com");

        CustomerDetails custDeatils = new CustomerDetails("Vellore", "Games");

        cust.setCustomerDetails(custDeatils);

        customerRepo.save(cust);
    }

}
