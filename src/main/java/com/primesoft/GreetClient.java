package com.primesoft;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// help to perform inter service communication with 06_GREET-API greetmethod
@FeignClient(name= "GREET-API")//through service -registry it takes url of the greet-api
public interface GreetClient {

	//url pattern is same which help to map with greet-api to inter communicate
	@GetMapping("/greet")
	public String invokeGreetApi();
}
