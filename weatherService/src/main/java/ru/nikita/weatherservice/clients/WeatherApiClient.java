package ru.nikita.weatherservice.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.nikita.library.dto.WeatherDTO;
import ru.nikita.library.mappers.JsonNodeWeatherMapper;
import ru.nikita.library.wrapper.JsonNodeWrapper;
import ru.nikita.weatherservice.repositories.WeatherRepository;

import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class WeatherApiClient implements WeatherRepository {

    @Qualifier("weather")
    private final RestTemplate restTemplate;
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public WeatherDTO getWeatherByCityName(String cityName) {

        ResponseEntity<String> forEntity = restTemplate.getForEntity("", String.class, cityName);
        return Optional.of(forEntity)
                .map(stringResponseEntity -> {
                    try {
                        return MAPPER.readTree(stringResponseEntity.getBody());
                    } catch (JsonProcessingException e) {
                        log.error(e.getMessage());
                    }
                    return null;
                })
                .map(jsonNode -> JsonNodeWeatherMapper.MAPPER.toWeatherDto(new JsonNodeWrapper(jsonNode)))
                .orElseThrow(RuntimeException::new);

    }

}
