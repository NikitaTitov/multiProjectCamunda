package ru.nikita.weatherservice.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

//	@Autowired
//	public WeatherApiClient(
//			ApiSettings apiSettings,
//			RestTemplate restTemplate
//	) {
//		this.restTemplate = restTemplate;
//		this.url = apiSettings.getWeatherApiUrl() + "?appid=" + apiSettings.getApiKey() + "&units=metric&lang=ru";
//	}

	public WeatherApiClient(
			ApiSettings apiSettings
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

}
