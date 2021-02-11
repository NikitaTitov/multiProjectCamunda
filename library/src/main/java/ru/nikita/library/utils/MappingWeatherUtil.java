package ru.nikita.library.utils;

import com.fasterxml.jackson.databind.JsonNode;
import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class MappingWeatherUtil {

	@Qualifier
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.SOURCE)
	public @interface Temperature {

	}

	@Qualifier
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.SOURCE)
	public @interface CityName {

	}

	@Temperature
	public String temperature(JsonNode jsonNode) {
		return jsonNode.get("main").get("temp").asText();
	}

	@CityName
	public String cityName(JsonNode jsonNode) {
		return jsonNode.get("name").asText();
	}
}
