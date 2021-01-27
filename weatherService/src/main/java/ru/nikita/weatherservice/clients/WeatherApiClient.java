package ru.nikita.weatherservice.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.nikita.library.dto.WeatherDTO;
import ru.nikita.weatherservice.configuration.ApiSettings;
import ru.nikita.weatherservice.repositories.WeatherRepository;

import java.util.Optional;

@Repository
public class WeatherApiClient implements WeatherRepository {

	private final RestTemplate restTemplate;
	private final String url;

//	public WeatherApiClient(RestTemplate restTemplate) {
//		this.restTemplate = restTemplate;
//	}

	public WeatherApiClient(
			ApiSettings apiSettings,
			RestTemplateBuilder restTemplateBuilder
	) {
		this.restTemplate = new RestTemplate();
		this.url = apiSettings.getWeatherApiUrl() + "?appid=" + apiSettings.getApiKey() + "&units=metric&lang=ru";
	}

	@Override
	public WeatherDTO getWeatherByCityName(String cityName) {
		WeatherDTO result = new WeatherDTO();
		ResponseEntity<String> response = restTemplate.getForEntity(url + "&q=" + cityName, String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = null;
		try {
			node = mapper.readTree(response.getBody());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		Optional.ofNullable(node).ifPresent(jsonNode -> {
			result.setTemperature(jsonNode.get("main").get("temp").asText());
			result.setCityName(jsonNode.get("name").asText());
		});
		return result;
	}

	@Override
	public WeatherDTO getWeatherByCityName(String appid, String cityName) {
		return null;
	}

}
