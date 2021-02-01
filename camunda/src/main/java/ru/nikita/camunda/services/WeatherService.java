package ru.nikita.camunda.services;

import ru.nikita.library.dto.WeatherDTO;

public interface WeatherService {

	WeatherDTO getWeatherByCityName(String cityName);
}
