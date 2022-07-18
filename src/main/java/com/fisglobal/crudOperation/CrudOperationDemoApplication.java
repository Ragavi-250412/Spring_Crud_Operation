package com.fisglobal.crudOperation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
//@EntityScan("com.fisglobal.crudOperation.model") // path of the entity model
//@EnableJpaRepositories("com.fisglobal.crudOperation.repo") // path of jpa repository 
@OpenAPIDefinition(info = @Info(title = "Security Alert API", version = "1.0.0", description = "Description Need to update...", license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0.html"), contact = @Contact(name = "FIS IT", email = "msol@fisglobal.com")))

@SpringBootApplication
public class CrudOperationDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudOperationDemoApplication.class, args);
		System.out.println("started");
	}

}
