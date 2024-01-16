package com.mrizkisaputra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
		@PropertySource("classpath:/database.properties")
})
public class BelajarSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringSecurityApplication.class, args);
	}

}
