package com.skillstorm.inventory_management_system;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryManagementSystemApplication {

	public static void main(String[] args) {
		 ApplicationContext context = (ApplicationContext) SpringApplication.run(InventoryManagementSystemApplication.class, args);
	}

}
