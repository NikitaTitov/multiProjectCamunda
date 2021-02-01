package ru.nikita.camunda.delegates;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import ru.nikita.camunda.configuration.WeatherApiSettings;
import ru.nikita.camunda.models.CamundaVariables;
import ru.nikita.library.dto.WeatherDTO;

@Slf4j
@RequiredArgsConstructor
public class WeatherInformationDelegate implements JavaDelegate {

	private final WeatherApiSettings apiSettings;

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		execution.setVariable(CamundaVariables.ERROR.getVariableName(), null);

		String cityName = String.valueOf(execution.getVariable(CamundaVariables.CITY_NAME.getVariableName()));

		try {
			WeatherDTO response = new RestTemplate().getForObject(
					apiSettings.getUrl() + "?cityName=" + cityName,
					WeatherDTO.class
			);
			execution.setVariable(CamundaVariables.CITY_NAME.name(), response.getCityName());
			execution.setVariable(CamundaVariables.TEMPERATURE.name(), response.getTemperature());
		} catch (RestClientException e) {
			execution.setVariable(CamundaVariables.ERROR.getVariableName(), e.getLocalizedMessage());
			log.error(e.getLocalizedMessage());
		}

	}
}
