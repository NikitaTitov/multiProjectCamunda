package ru.nikita.weatherservice.configuration.feign;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Configuration("weatherApiSettingsSome")
@ConfigurationProperties("app.api")
public class ApiSettings {

	private String weatherApiUrl;
	@NotBlank
	private String apiKey;
}
