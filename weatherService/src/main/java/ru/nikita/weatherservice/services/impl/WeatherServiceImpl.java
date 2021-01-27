package ru.nikita.weatherservice.services.impl;

import org.springframework.stereotype.Service;
import ru.nikita.library.dto.WeatherDTO;
import ru.nikita.weatherservice.repositories.WeatherRepository;
import ru.nikita.weatherservice.services.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

	private final WeatherRepository weatherRepository;

	public WeatherServiceImpl(
			WeatherRepository weatherRepository
	) {
		this.weatherRepository = weatherRepository;
	}

	@Override
	public WeatherDTO getWeatherByCity(String city) {
		return weatherRepository.getWeatherByCityName(city);
	}
}
