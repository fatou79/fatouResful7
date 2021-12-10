package com.fatou.rest.webservices.restfulwebservices7.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
@RestController
public class SomeBeanController {
	
//	@GetMapping("/filtering")
//	public SomeBean retrieveSomeBean() {
//		return new SomeBean("value1","value2","value3");
//			

	
//	@GetMapping("/filtering-list")
//	public List<SomeBean> retrieveListSomeBean(){
//		return Arrays.asList(new SomeBean("value1","value2","value3"), 
//			new SomeBean("value12", "value22","value32"));
//			
//	}
	
	//field1,field3
			@GetMapping("/filtering-list")
			public MappingJacksonValue retrieveOfSomeBeans() {
				List<SomeBean> list =Arrays.asList(new SomeBean("Value1","Value2","Value3"),
				new SomeBean("value12", "value22", "value32"));

				SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("fields2", "fields3");

				FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

				MappingJacksonValue mapping = new MappingJacksonValue(list);

				mapping.setFilters(filters);

				return mapping;
			}

	}
	




