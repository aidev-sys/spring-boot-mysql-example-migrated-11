package guru.springframework;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMySqlApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootMySqlApplication.class);
        Map<String, Object> defaultProps = new HashMap<>();
        // Explicitly set PostgreSQL driver to avoid legacy MySQL driver lookup
        defaultProps.put("spring.datasource.driver-class-name", "org.postgresql.Driver");
        app.setDefaultProperties(defaultProps);
        app.run(args);
    }
}