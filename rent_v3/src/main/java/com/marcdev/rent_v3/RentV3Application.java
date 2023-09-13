package com.marcdev.rent_v3;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "rentAPI",
				description = "RentApi is the API built by MARC DEV and use for an application name RentApp ",
				version = "1.0",
				termsOfService = "mgsoft",
				contact = @Contact(
						name = "Marc William",
						url = "http://marcdev.com",
						email = "marcwilliam756@gmail.com"
				),
				license = @License(
						name = "license",
						url = "openMarcdev.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "\n\n\nmade by Marc William",
				url = "http:#"
		)
)
public class RentV3Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RentV3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
