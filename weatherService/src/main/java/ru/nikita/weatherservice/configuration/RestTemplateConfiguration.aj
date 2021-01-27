package ru.nikita.weatherservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import ru.nikita.weatherservice.configuration.ApiSettings;

@Configuration
public aspect RestTemplateConfiguration {

//	@Autowired
//	private ApiSettings apiSettings;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.rootUri("apiSettings.getWeatherApiUrl()").build();
	}
}
