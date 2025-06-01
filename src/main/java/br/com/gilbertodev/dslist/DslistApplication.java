package br.com.gilbertodev.dslist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class to bootstrap the DSList Spring Boot application.
 *
 * @author Gilberto Dev
 */
@SpringBootApplication
public class DslistApplication {

    /**
     * Main method that starts the Spring Boot application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(DslistApplication.class, args);
    }
}
