package com.infybuzz.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.infybuzz.listener.FirstJobListener;
import com.infybuzz.service.SecondTasklet;


@Configuration
public class SampleJob {

	@Autowired
	JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	SecondTasklet secondTasklet;
	
	@Autowired
	FirstJobListener firstJobListener;
	
    @Bean
	public Job firstJob() {
    	
    	 return jobBuilderFactory.get("First Job")
    			 .incrementer(new RunIdIncrementer())
    			 .start(firstStep())
    			 .next(secondStep())
    			 .listener(firstJobListener)
    			 .build();
	 
   }
    
   public Step firstStep() {
	   
	   return stepBuilderFactory.get("First Step")
			   .tasklet(firstTask())
			   .build();
	   
	 
   }
   

   public Tasklet firstTask() {
			   
			   
			 return  new Tasklet() {
		
		@Override
		public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {


			
			 System.out.println("This is the first tasklet step");
			return RepeatStatus.FINISHED; 
		}
	};
   }
   
   
public Step secondStep() {
	   
	   return stepBuilderFactory.get("Second Step")
			   .tasklet(secondTasklet)
			   .build();
	   
	 
   }

//   public Tasklet secondTask() {
//	   
//	   
//		 return  new Tasklet() {
//	
//	@Override
//	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//
//
//		
//		 System.out.println("This is the second tasklet step");
//		return RepeatStatus.FINISHED; 
//	}
//};
//}
    
    
    

}
