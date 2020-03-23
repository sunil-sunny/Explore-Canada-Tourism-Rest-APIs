/*
 * package com.ExploreCanada.packages.rest;
 * 
 * import java.util.HashMap; import java.util.Map;
 * 
 * import org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.client.RestTemplate;
 * 
 * import com.ExploreCanada.packages.Jwt.JwtResponse;
 * 
 * @RestController
 * 
 * @CrossOrigin("*") public class LoginRestController {
 * 
 * @RequestMapping(value="/login/{userid}/{password}",method =
 * RequestMethod.POST) public String doLogin(@PathVariable("userid") String
 * userid,@PathVariable("password") String password) {
 * 
 * System.out.println(userid); System.out.println(password);
 * 
 * RestTemplate restTemplate=new RestTemplate(); Map<String,String>
 * credentials=new HashMap<String, String>(); credentials.put("username",
 * userid); credentials.put("password", password); String
 * url="http://localhost:8080/authenticate"; JwtResponse
 * token=restTemplate.postForObject(url, credentials, JwtResponse.class);
 * System.out.println(token.getToken()); return token.getToken();
 * 
 * } }
 */