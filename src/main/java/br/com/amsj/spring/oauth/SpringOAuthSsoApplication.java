package br.com.amsj.spring.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@SpringBootApplication
@EnableOAuth2Sso
public class SpringOAuthSsoApplication extends WebSecurityConfigurerAdapter {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringOAuthSsoApplication.class, args);
	}

	protected void configure(HttpSecurity httpSecurity) throws Exception {
	
		httpSecurity
			.antMatcher("/**")
			.authorizeRequests()
			.antMatchers("/", "/login**", "/webjars/**", "/error**")
			.permitAll()
			.anyRequest()
			.authenticated().and().logout()
			.logoutSuccessUrl("/").permitAll()
			.and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	
	}

}
