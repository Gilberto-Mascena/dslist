package br.com.gilbertodev.dslist.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("DSList API")
                .version("1.0.0")
                .description("Documentation of DSList API")
                .license(new License()
                        .url("https://github.com/Gilberto-Mascena/dslist/blob/main/LICENSE.md")
                        .name("MIT License")));
    }
}
