package com.infybuzz.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("removal")
@Configuration
public class SampleJob {

	@Autowired
	JobBuilderFactory jobBuilderFactory;
	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
    @Bean
	public Job firstJob() {
    	
    	 return jobBuilderFactory.get("First Job").start(firstStep()).build();
	 
   }
    
   public Step firstStep() {
	   
	   return stepBuilderFactory.get("First Step").tasklet(firstTask()).build();
	   
	 
   }
   
   public Tasklet firstTask() {
			   
			   
			 return  new Tasklet() {
		
		@Override
		public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
			// TODO Auto-generated method stub
			
			 System.out.println("This is the first job");
			return RepeatStatus.FINISHED; 
		}
	};
   }
    
    
    

}
