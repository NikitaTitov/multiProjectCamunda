package ru.nikita.weatherservice.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Component
@RequiredArgsConstructor
public class AppConfiguration {

	private final ApiSettings apiSettings;

	@Bean("weather")
	public RestTemplate getRestTemplate() {
		String baseUri = apiSettings.getWeatherApiUrl() + "?appid=" + apiSettings.getApiKey() + "&units=metric&lang=ru&q={city}";
		return new RestTemplateBuilder()
				.uriTemplateHandler(new DefaultUriBuilderFactory(baseUri))
				.build();
	}
}
