package com.Spring.service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

	private static final String SECRET_KEY = "3cFz!x@9nQw8R^2sLpDgZhVtKrUeJyHs";
	
	@SuppressWarnings("deprecation")
	public String generateToken(String username) {
		
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+100*60*60))
				.signWith(SignatureAlgorithm.HS256,SECRET_KEY.getBytes(StandardCharsets.UTF_8)).compact();
			
	}
	public String extractUsername(String token) {
		return Jwts.parser()
				.setSigningKey(SECRET_KEY.getBytes())
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	
	public boolean validateToken(String token,String username) {
		return username.equals(extractUsername(token)) && isTokenExpired(token);
	}
	private boolean isTokenExpired(String token) {
		Date expire = Jwts.parser()
				.setSigningKey(SECRET_KEY.getBytes())
				.parseClaimsJws(token)
				.getBody()
				.getExpiration();
		return expire.before(new Date());
	}

}
