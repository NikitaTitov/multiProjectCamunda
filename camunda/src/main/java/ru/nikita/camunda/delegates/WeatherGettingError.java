package ru.nikita.camunda.delegates;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import ru.nikita.camunda.models.CamundaVariables;

@Slf4j
public class WeatherGettingError implements JavaDelegate {
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.error(String.valueOf(execution.getVariable(CamundaVariables.ERROR.getVariableName())));
	}
}
