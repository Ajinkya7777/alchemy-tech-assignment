package com.alchemytech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableSwagger2
//@EnableWebMvc
//@Configuration
@SpringBootApplication
public class AlchemyTechApplication {

	public static final String AUTHORIZATION_HEADER = "Authorization";

	public static void main(String[] args) {
		SpringApplication.run(AlchemyTechApplication.class, args);
	}

	/*
	 * private ApiKey apiKey() {
	 * 
	 * return new ApiKey("JWT", AUTHORIZATION_HEADER, "Bearer"); }
	 * 
	 * @Bean public Docket api() { return new
	 * Docket(DocumentationType.SWAGGER_2).securityContexts(Arrays.asList(
	 * securityContext())) .securitySchemes(Arrays.asList(apiKey())).select()
	 * .apis(RequestHandlerSelectors.basePackage("com.alchemytech")).paths(
	 * PathSelectors.any()) .build().apiInfo(myApiInfo()); }
	 * 
	 * private SecurityContext securityContext() { return
	 * SecurityContext.builder().securityReferences(defaultAuth()).build(); }
	 * 
	 * private List<SecurityReference> defaultAuth() { AuthorizationScope
	 * authorizationScope = new AuthorizationScope("global", "accessEverything");
	 * AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	 * authorizationScopes[0] = authorizationScope; return Arrays.asList(new
	 * SecurityReference("JWT", authorizationScopes)); }
	 * 
	 * private ApiInfo myApiInfo() { return new
	 * ApiInfoBuilder().title("Institute Application API Information")
	 * .description("My Application API info").contact(new Contact("Ajinkya Shinde",
	 * "https:www.linkedin.com/in/swati-vernwal-1a50051a9",
	 * "shindeajinkya09.as@gmail.com"))
	 * .license("Full-Time").licenseUrl("NA").build(); }
	 * 
	 * // http://localhost:8080/swagger-ui/index.html
	 */

}
