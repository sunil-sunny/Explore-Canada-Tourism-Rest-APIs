package com.ExploreCanada.packages.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ExploreCanada.packages.Jwt.JwtRequest;
import com.ExploreCanada.packages.Jwt.JwtResponse;
import com.ExploreCanada.packages.Jwt.JwtTokenUtil;


@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private com.ExploreCanada.packages.service.JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		String genrateOtpUrl="http://localhost:8080/send/otp";
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		System.out.println("Token is :"+token);
		JwtResponse tokenResponse=new JwtResponse(token);
		System.out.println("Token response is "+tokenResponse);
		RestTemplate restTemplate=new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		//Can add token for the authorization
		headers.add("security", "Basic "+token);
		//can post and get the ResponseBean 
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		HttpEntity<Object> entity=new HttpEntity<Object>(headers);
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));        
		messageConverters.add(converter);  
		restTemplate.setMessageConverters(messageConverters);
		try {
			restTemplate.postForObject(genrateOtpUrl, entity, ResponseEntity.class);
		}
		catch(Exception e) {
			System.out.println("Exception catched");
		}
		return ResponseEntity.ok(tokenResponse);
	}
	
	/*
	 * @RequestMapping(value="/validateOtp/{otp}",method = RequestMethod.POST)
	 * public ResponseEntity<Object> validateOtp(@PathVariable String
	 * otp,@RequestHeader("security") String security) {
	 * 
	 * System.out.println(otp); System.out.println(security); RestTemplate
	 * restTemplate=new RestTemplate(); HttpHeaders headers = new HttpHeaders();
	 * //Can add token for the authorization headers.add("security",
	 * "Basic "+security); headers.add("otp", otp); //can post and get the
	 * ResponseBean List<HttpMessageConverter<?>> messageConverters = new
	 * ArrayList<HttpMessageConverter<?>>(); MappingJackson2HttpMessageConverter
	 * converter = new MappingJackson2HttpMessageConverter(); HttpEntity<Object>
	 * entity=new HttpEntity<Object>(headers);
	 * converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
	 * messageConverters.add(converter);
	 * restTemplate.setMessageConverters(messageConverters); ResponseEntity<Object>
	 * response=null; try {
	 * response=restTemplate.postForObject("http://localhost:8080/verify/otp",
	 * entity, ResponseEntity.class); } catch(Exception e) {
	 * System.out.println("Exception catched"); } if(response==null) { response=new
	 * ResponseEntity<Object>(HttpStatus.BAD_REQUEST); } return response;
	 * 
	 * 
	 * }
	 */
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}