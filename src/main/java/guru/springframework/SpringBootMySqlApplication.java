package guru.springframework;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Spring Boot application.
 * Configures default properties to ensure the correct PostgreSQL driver
 * and a fallback physical naming strategy that is always available.
 */
@SpringBootApplication
public class SpringBootMySqlApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootMySqlApplication.class);
        Map<String, Object> defaultProps = new HashMap<>();
        // Explicitly set PostgreSQL driver to avoid legacy MySQL driver lookup
        defaultProps.put("spring.datasource.driver-class-name", "org.postgresql.Driver");
        // Use a standard physical naming strategy that is guaranteed to exist
        defaultProps.put("spring.jpa.hibernate.naming.physical-strategy",
                "org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
        app.setDefaultProperties(defaultProps);
        app.run(args);
    }
}