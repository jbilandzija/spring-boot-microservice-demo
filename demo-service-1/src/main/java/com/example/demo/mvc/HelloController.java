package com.example.demo.mvc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class HelloController {

	private final Map<String, ResponseModel> responseModelMap;

	  /**
	   * initialize and populate Map for Example
	   */
	  public HelloController() {
	    this.responseModelMap = new HashMap<>();
	    responseModelMap.put("1", new ResponseModel("Response mit Message 1"));
	    responseModelMap.put("2", new ResponseModel("Response mit Message 2"));
	    responseModelMap.put("3", new ResponseModel("Response mit Message 3"));
	    responseModelMap.put("4", new ResponseModel("Response mit Message 4"));
	    responseModelMap.put("5", new ResponseModel("Response mit Message 5"));
	    responseModelMap.put("6", new ResponseModel("Response mit Message 6"));
	    responseModelMap.put("7", new ResponseModel("Response mit Message 7"));
	    responseModelMap.put("8", new ResponseModel("Response mit Message 8"));
	    responseModelMap.put("9", new ResponseModel("Response mit Message 9"));
	  }

	  /**
	   * default response
	   */
	  @RequestMapping("/")
	  public ResponseModel getGreeting() {
	    return new ResponseModel("hello reutlingen");
	  }

	  /**
	   * if you had enough!
	   */
	  @RequestMapping("/pause")
	  public ResponseModel getPause() {
	    return new ResponseModel("alter mach ma pause!");
	  }

	  /**
	   * get response from Map for a specific ID, which is passed als Variable into this request
	   */
	  @GetMapping("/response/{id}")
	  public ResponseModel getResponseMapById(@PathVariable String id) {
	    return responseModelMap.get(id);
	  }

	  @GetMapping("/response")
	  public Map<String, ResponseModel> getResponseMap() {
	    return responseModelMap;
	  }

	  @PostMapping("/response/{id}")
	  public ResponseModel createNewResponseById(@PathVariable String id, @RequestBody ResponseModel body) throws IllegalAccessException {
	    if (responseModelMap.containsKey(id)) {
	      throw new IllegalAccessException("Update not supported in POST!");
	    }
	    return responseModelMap.put(id, body);
	  }

	  @DeleteMapping("/response/{id}")
	  public ResponseModel deleteResponseById(@PathVariable String id) {
	    return responseModelMap.remove(id);
	  }

	  @PutMapping("/response/{id}")
	  public ResponseModel updateResponseById(@PathVariable String id, @RequestBody ResponseModel body) throws IllegalAccessException {
	    if (responseModelMap.containsKey(id)) {
	      return responseModelMap.put(id, body);
	    } else {
	      throw new IllegalAccessException("Create not supported in PUT!");
	    }
	  }
	
}
