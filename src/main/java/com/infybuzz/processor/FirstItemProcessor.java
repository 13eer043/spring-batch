package com.infybuzz.processor;

import org.springframework.batch.item.ItemProcessor;

public class FirstItemProcessor implements ItemProcessor<Integer, Long> {

	@Override
	public Long process(Integer item) throws Exception {
		
		return null;
	}

}
