package ru.nikita.weatherservice.services;


import ru.nikita.library.dto.WeatherDTO;

public interface WeatherService {

	WeatherDTO getWeatherByCity(String city);
}
