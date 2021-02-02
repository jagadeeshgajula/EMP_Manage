package com.emp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeBankController {

	
	List data = new ArrayList();
	@GetMapping(value="/test")
	public String test() {
		return "hello";
	}
	
	@GetMapping(value="/data")
	public List data(){
		List list= new ArrayList<>();
		list.add("hello");
		list.add("bye");
		
		return list;
	}
	
	
}
