package ru.nikita.weatherservice.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nikita.library.dto.WeatherDTO;
import ru.nikita.weatherservice.repositories.WeatherRepository;
import ru.nikita.weatherservice.services.WeatherService;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;

    @Override
    public WeatherDTO getWeatherByCity(String city) {
        return weatherRepository.getWeatherByCityName(city);
    }
}
