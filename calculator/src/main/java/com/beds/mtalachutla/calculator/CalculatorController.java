package com.beds.mtalachutla.calculator;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
	
	private String history = "";
	
	@GetMapping("/test")
	public String test(){
		return "okay";
	}
	
	@GetMapping(value="/add")
	public ResponseEntity<String> add(@RequestParam("op1") Double op1, @RequestParam("op2") Double op2){
		String result = op1 + " + " + op2 + " = " + (op1+op2);
		history = history.concat(result).concat("</br>");
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value="/minus")
	public ResponseEntity<String> minus(@RequestParam("op1") Double op1, @RequestParam("op2") Double op2){
		String result = op1 + " - " + op2 + " = " + (op1-op2);
		history = history.concat(result).concat("</br>");
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value="/product")
	public ResponseEntity<String> product(@RequestParam("op1") Double op1, @RequestParam("op2") Double op2){
		String result = op1 + " * " + op2 + " = " + (op1*op2);
		history = history.concat(result).concat("</br>");
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value="/divide")
	public ResponseEntity<String> divide(@RequestParam("op1") Double op1, @RequestParam("op2") Double op2){
		String result = op1 + " / " + op2 + " = " + (op1/op2);
		history = history.concat(result).concat("</br>");
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value="/history")
	public ResponseEntity<String> history(){
		return ResponseEntity.ok().body(history);
	}
	
	@GetMapping(value="/clear")
	public ResponseEntity<String> clear(){
		history = "";
		return ResponseEntity.ok().body("history cleared");
	}

}
