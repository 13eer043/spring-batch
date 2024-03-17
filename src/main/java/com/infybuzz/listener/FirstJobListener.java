package com.infybuzz.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.stereotype.Component;

@Component
public class FirstJobListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("Before job run - Job Name: "+ jobExecution.getJobInstance().getJobName());
		System.out.println("Job parameters: "+ jobExecution.getJobParameters());
		System.out.println("Job Execution Context: "+jobExecution.getExecutionContext());
		
		ExecutionContext context = jobExecution.getExecutionContext();
		context.put("JECkey", "JECvalue");
		jobExecution.setExecutionContext(context);
		}

	@Override
	public void afterJob(JobExecution jobExecution) {
	System.out.println("After job run - Job Name: "+jobExecution.getJobInstance().getJobName());
	System.out.println("Job parameters: "+jobExecution.getJobParameters());
	System.out.println("Job Execution Context: "+jobExecution.getExecutionContext());
		
	}

}
