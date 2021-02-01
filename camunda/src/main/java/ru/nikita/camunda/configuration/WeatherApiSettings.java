package ru.nikita.camunda.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("application.api.weather")
public class WeatherApiSettings {

	private String url;
}
