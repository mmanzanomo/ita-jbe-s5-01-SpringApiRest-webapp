package cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n03;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class S05T01N03ManzanoMonteroMiguelApplication {

	public static void main(String[] args) {
		SpringApplication.run(S05T01N03ManzanoMonteroMiguelApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Client Flowers API")
						.version("0.1")
						.description("API Client with Spring Boot to manage a list of flowers")
						.termsOfService("http://swagger.io/terms")
						.license(new License().name("Apache 2.0")
								.url("http://springdoc.org")
						));
	}

}
