package br.com.amsj.spring.oauth.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuth2Controller {

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}
}
