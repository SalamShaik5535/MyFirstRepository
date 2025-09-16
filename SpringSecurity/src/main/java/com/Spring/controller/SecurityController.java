package com.Spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure")
public class SecurityController {

	  @GetMapping("/public")
	    public String publicApi() {
	        return "This is a PUBLIC endpoint.";
	    }

	    @GetMapping("/secure")
	    public String secureApi() {
	        return "This is a SECURE endpoint. You must be logged in!";
	    }
}
