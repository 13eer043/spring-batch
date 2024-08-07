package com.infybuzz.reader;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class FirstItemReader implements ItemReader<Integer> {
	
	List<Integer> items = Arrays.asList(1,2,3,4,5,6,7,8,9,10); 
	int i=0;

	@Override
	public Integer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("Inside item reader");
		  
		Integer item;
		
		if(i<items.size()) {
			item =items.get(i);
			i++;
		 return item;
		}
		i=0;
		return null;
	}

}
