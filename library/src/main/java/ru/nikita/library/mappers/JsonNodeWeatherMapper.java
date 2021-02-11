package ru.nikita.library.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.nikita.library.dto.WeatherDTO;
import ru.nikita.library.utils.MappingWeatherUtil;
import ru.nikita.library.utils.MappingWeatherUtil.Temperature;
import ru.nikita.library.utils.MappingWeatherUtil.CityName;
import ru.nikita.library.wrapper.JsonNodeWrapper;

@Mapper(uses = MappingWeatherUtil.class)
public interface JsonNodeWeatherMapper {

	JsonNodeWeatherMapper MAPPER = Mappers.getMapper(JsonNodeWeatherMapper.class);

	@Mapping(source = "jsonNode", target = "temperature", qualifiedBy = Temperature.class)
	@Mapping(source = "jsonNode", target = "cityName", qualifiedBy = CityName.class)
	WeatherDTO toWeatherDto(JsonNodeWrapper jsonNode);
}
