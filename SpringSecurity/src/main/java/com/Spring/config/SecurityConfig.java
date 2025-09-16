package com.Spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Spring.service.JwtFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig  {
	
    private final JwtFilter jwtFilter;
    public SecurityConfig(JwtFilter jwtFilter) {   // constructor injection
        this.jwtFilter = jwtFilter;
    }
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(auth->auth
				.requestMatchers("/api/user/**","/auth/**").permitAll()
				.anyRequest().authenticated())
		
		   .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

	        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
		
	}
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withUsername("user")
				.password(passwordEncoder().encode("password"))
				.roles("user")
				.build();
		UserDetails admin = User.withUsername("admin")
				.password(passwordEncoder().encode("admin"))
				.roles("admin")
				.build();
		return new InMemoryUserDetailsManager(user,admin);
	}
	
	 @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
	        return config.getAuthenticationManager();
	    }
	 
	@Bean
	public PasswordEncoder passwordEncoder() {
	
		return new BCryptPasswordEncoder();
	}
		
	
}
