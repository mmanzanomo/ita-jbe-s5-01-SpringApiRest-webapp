package cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n02;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoS05T01N02ManzanoMonteroMiguelApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoS05T01N02ManzanoMonteroMiguelApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
				.title("Flowers API")
				.version("0.1")
				.description("API with Spring Boot to manage a list of flowers")
				.termsOfService("http://swagger.io/terms")
				.license(new License().name("Apache 2.0")
				.url("http://springdoc.org")
				));
	}

}
