package com.apart.ge.apartments;

import com.apart.ge.apartments.repository.PropertyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@SpringBootApplication
@Configuration
public class ApartmentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApartmentsApplication.class, args);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests((authz) -> authz
						.anyRequest().permitAll()
				)
				.httpBasic(withDefaults());
		return http.build();
	}

	public CommandLineRunner commandLineRunner(PropertyRepository propertyRepository) {

		return args -> {

        };
	}


}
