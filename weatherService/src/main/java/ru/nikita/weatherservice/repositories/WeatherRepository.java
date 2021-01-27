package ru.nikita.weatherservice.repositories;

import ru.nikita.library.dto.WeatherDTO;

public interface WeatherRepository {

	WeatherDTO getWeatherByCityName(String cityName);

	WeatherDTO getWeatherByCityName(String appid, String cityName);

}
