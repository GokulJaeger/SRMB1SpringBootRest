package com.org.springrest4.springrest4;

import java.util.Arrays;
import java.util.Date;

import javax.transaction.Transactional;

import com.org.springrest4.springrest4.model.Goods;
import com.org.springrest4.springrest4.model.Supplier;
import com.org.springrest4.springrest4.model.Vendor;
import com.org.springrest4.springrest4.repository.GoodsRepository;
import com.org.springrest4.springrest4.repository.SupplierRepository;
import com.org.springrest4.springrest4.repository.VendorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootApplication
public class Springrest4Application implements CommandLineRunner {

    @Autowired
	private GoodsRepository goodsRepo;

    @Autowired
	private VendorRepository vendorRepo;

    @Autowired
	private SupplierRepository supplierRepo;

	public static void main(String[] args) {
		SpringApplication.run(Springrest4Application.class, args);
	}
	
    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        Goods b1 = new Goods("Spring Boot");
        Goods b2 = new Goods("Spring Data JPA");
        goodsRepo.saveAll(Arrays.asList(b1, b2));

        Vendor p1 = new Vendor("HelloKoding 1");
        Vendor p2 = new Vendor("HelloKoding 2");
        vendorRepo.saveAll(Arrays.asList(p1, p2));

        Supplier bp1 = new Supplier(b1, p1, new Date());
        Supplier bp2 = new Supplier(b1, p2, new Date());
        Supplier bp3 = new Supplier(b2, p1, new Date());
        Supplier bp4 = new Supplier(b2, p2, new Date());
        supplierRepo.saveAll(Arrays.asList(bp1, bp2, bp3, bp4));
    }

}
