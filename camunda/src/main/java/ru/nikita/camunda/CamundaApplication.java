package ru.nikita.camunda;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.nikita.camunda.configuration.WeatherApiSettings;

@SpringBootApplication
@EnableProcessApplication
@EnableConfigurationProperties({WeatherApiSettings.class})
public class CamundaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamundaApplication.class, args);
	}

}

