package ru.nikita.weatherservice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

	@Autowired
	private ApiSettings apiSettings;

	@Bean
	public RestTemplate restTemplate(
			RestTemplateBuilder restTemplateBuilder
	) {
		return restTemplateBuilder.rootUri(apiSettings.getWeatherApiUrl()).build();
	}
}
