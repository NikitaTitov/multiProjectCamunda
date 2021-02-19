package ru.nikita.library.mappers;

import com.fasterxml.jackson.databind.JsonNode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import ru.nikita.library.dto.WeatherDTO;
import ru.nikita.library.utils.CityName;
import ru.nikita.library.utils.Temperature;
import ru.nikita.library.wrapper.JsonNodeWrapper;

@Mapper
public interface JsonNodeWeatherMapper {

	JsonNodeWeatherMapper MAPPER = Mappers.getMapper(JsonNodeWeatherMapper.class);

	@Named("WeatherDescription")
	default String weatherDescription(JsonNode node) {
		return node.get("weather").get(0).get("description").asText();
	}

	@Temperature
	default String temperature(JsonNode jsonNode) {
		return jsonNode.get("main").get("temp").asText();
	}

	@CityName
	default String cityName(JsonNode jsonNode) {
		return jsonNode.get("name").asText();
	}

	@Mapping(source = "jsonNode", target = "temperature", qualifiedBy = Temperature.class)
	@Mapping(source = "jsonNode", target = "cityName", qualifiedBy = CityName.class)
	@Mapping(source = "jsonNode", target = "description", qualifiedByName = "WeatherDescription")
	WeatherDTO toWeatherDto(JsonNodeWrapper jsonNode);
}
