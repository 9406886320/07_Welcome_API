package com.primesoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.primesoft.GreetClient;
import com.primesoft.binding.Pet;
import com.primesoft.binding.WelcomeResponse;

@RestController
public class WelcomeRestController {

	@Autowired
	private GreetClient greetClient;
	
	@GetMapping("/welcome")
	public WelcomeResponse getWelcomeMsg() {
		
		String welcomeMsg= "Welcome to PrimeSoft...!!";
		
		//Interservice Communication
		String greetMsg= greetClient.invokeGreetApi();
	/*	
		
		//third party external api communication / External Service communication
		RestTemplate rt= new RestTemplate();
		//third party api url
		String petEndpointUrl ="https://fbqm3v39o8.execute-api.ap-south-1.amazonaws.com/dev/pets/1";
		ResponseEntity<Pet> entity=rt.getForEntity(petEndpointUrl,Pet.class);
		Pet petData= entity.getBody();
		
		*/
		WelcomeResponse finalResponse= new WelcomeResponse();
		
		finalResponse.setGreetMsg(greetMsg);
		finalResponse.setWelcomeMsg(welcomeMsg);
		//finalResponse.setPet(petData);
		
		
		
		return finalResponse;
	}
}
