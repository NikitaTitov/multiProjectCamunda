package ru.nikita.camunda.models;

import lombok.Getter;

@Getter
public enum CamundaVariables {
	ERROR("error"),
	CITY_NAME("cityName"),
	TEMPERATURE("temperature");

	private String variableName;

	CamundaVariables(String valueName) {}
}
