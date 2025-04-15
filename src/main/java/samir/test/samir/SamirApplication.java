package samir.test.samir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "samir.test.samir")
@EnableJpaRepositories("samir.test.samir.repository")
public class SamirApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamirApplication.class, args);
	}

}
