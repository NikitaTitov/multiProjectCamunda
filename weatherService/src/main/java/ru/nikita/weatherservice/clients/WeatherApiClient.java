package ru.nikita.weatherservice.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.nikita.library.dto.WeatherDTO;
import ru.nikita.weatherservice.repositories.WeatherRepository;

import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class WeatherApiClient implements WeatherRepository {
	@Qualifier("weather")
	private final RestTemplate restTemplate;

	@Override
	public WeatherDTO getWeatherByCityName(String cityName) {

		return Optional.of(restTemplate.getForEntity("", String.class, cityName))
				.map(stringResponseEntity -> {
					try {
						return new ObjectMapper().readTree(stringResponseEntity.getBody());
					} catch (JsonProcessingException e) {
						log.error(e.getMessage());
					}
					return null;
				})
				.map(jsonNode -> {
					WeatherDTO result = new WeatherDTO();

					result.setTemperature(jsonNode.get("main").get("temp").asText());
					result.setCityName(jsonNode.get("name").asText());
					return result;
				})
				.orElseThrow(RuntimeException::new);

	}

}
