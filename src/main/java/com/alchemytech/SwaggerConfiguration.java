package com.alchemytech;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfiguration {

	@Bean
	public OpenAPI myOpenAPI() {

		Server local = new Server();
		local.setDescription("Server URL in Local environment");

		Contact contact = new Contact();
		contact.setEmail("Ajinkya@gmail.com");
		contact.setName("Ajinkya");
		contact.setUrl("https://github.com/Ajinkya7777");

		Info info = new Info().title("User Management API").version("1.0").contact(contact)
				.description("This API exposes endpoints to manage User.");
		return new OpenAPI().info(info).servers(List.of(local));
	}
}
