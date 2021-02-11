package ru.nikita.library.wrapper;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class JsonNodeWrapper {

	private final JsonNode jsonNode;
}
