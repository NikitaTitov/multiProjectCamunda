package ru.nikita.weatherservice.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ConfigurationProperties("app.api")
public class ApiSettings {

    @NotBlank
    private String weatherApiUrl;

    @NotBlank
    private String apiKey;
}
