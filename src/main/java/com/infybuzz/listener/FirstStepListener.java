package com.infybuzz.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.stereotype.Component;

@Component
public class FirstStepListener implements StepExecutionListener {

	@Override
	public void beforeStep(StepExecution stepExecution) {
		System.out.println("Before Step method- Step name: "+ stepExecution.getStepName());
        System.out.println("Job execution context: "+ stepExecution.getJobExecution().getExecutionContext());
        System.out.println("Step execution context: "+ stepExecution.getExecutionContext());
        
        ExecutionContext stepExecutionContext = stepExecution.getExecutionContext();
        stepExecutionContext.put("SEC-key", "SEC-value");
        stepExecution.setExecutionContext(stepExecutionContext);
        
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		System.out.println("After step method - Step Name: "+ stepExecution.getStepName());
		System.out.println("Job execution context: "+ stepExecution.getJobExecution().getExecutionContext());
		System.out.println("Step execution context: "+stepExecution.getExecutionContext());
		
		
		return null;
	}

}
