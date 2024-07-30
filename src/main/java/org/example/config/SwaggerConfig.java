package org.example.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
        import io.swagger.v3.oas.models.OpenAPI;
        import io.swagger.v3.oas.models.info.Info;
        import io.swagger.v3.oas.models.info.License;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Currency Converter API")
                        .description("API for converting currencies and getting exchange rates")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Currency Converter API Documentation")
                        .url("http://localhost:8080/swagger-ui.html"));
    }
}

