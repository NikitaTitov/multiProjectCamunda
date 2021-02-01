package ru.nikita.camunda.configuration.camunda;

import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.nikita.camunda.configuration.WeatherApiSettings;
import ru.nikita.camunda.delegates.WeatherGettingError;
import ru.nikita.camunda.delegates.WeatherInformationDelegate;

@Configuration
public class DelegateConfiguration {

	@Bean
	public JavaDelegate weatherInformationDelegate(WeatherApiSettings apiSettings) {
		return new WeatherInformationDelegate(apiSettings);
	}

	@Bean
	public JavaDelegate weatherError() {
		return new WeatherGettingError();
	}

}
