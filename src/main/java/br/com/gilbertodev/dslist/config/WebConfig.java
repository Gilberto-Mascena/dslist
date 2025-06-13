package br.com.gilbertodev.dslist.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class for defining CORS (Cross-Origin Resource Sharing) rules
 * for the Spring Boot application.
 *
 * <p>This configuration allows the Angular frontend, running at {@code http://localhost:4200},
 * to make requests to the API. It defines the allowed HTTP methods, headers,
 * and credentials.</p>
 *
 * @author Gilberto Dev
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configures global CORS mappings for the application.
     *
     * <p>Allows requests from {@code http://localhost:4200} to all endpoints ({@code /**}),
     * accepting all HTTP methods (GET, POST, PUT, DELETE, etc.), all headers,
     * and supporting the sending of credentials (such as cookies or authorization headers).</p>
     *
     * @param registry The {@link CorsRegistry} to configure the CORS rules.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
