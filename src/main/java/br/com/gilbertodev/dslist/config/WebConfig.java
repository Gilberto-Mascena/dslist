package br.com.gilbertodev.dslist.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class for defining CORS (Cross-Origin Resource Sharing) rules.
 *
 * <p>The allowed origins are read from the application properties and applied
 * globally to all endpoints.</p>
 *
 * @author Gilberto Dev
 */
@Configuration
public class WebConfig {

    @Value("${cors.origins}")
    private String corsOrigins;

    /**
     * Configures CORS mappings for the entire application.
     *
     * @return a {@link WebMvcConfigurer} with CORS rules applied
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("*").allowedOrigins(corsOrigins.split(","));
            }
        };
    }
}
