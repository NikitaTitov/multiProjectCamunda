package ru.nikita.weatherservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nikita.library.dto.WeatherDTO;
import ru.nikita.weatherservice.services.WeatherService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class WeatherController {

	private final WeatherService weatherService;

	@GetMapping
	public WeatherDTO getWeatherByCity(String city) {
		return weatherService.getWeatherByCity(city);
	}
}
