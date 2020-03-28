package com.ExploreCanada.packages.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ExploreCanada.packages.Jwt.JwtRequestFilter;
import com.ExploreCanada.packages.OtpSystem.OtpDetails;
import com.ExploreCanada.packages.entities.CustomerSpecificDetails;
import com.ExploreCanada.packages.service.CustomerDetailsService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class OtpSystemRestController {
	
	private static Map<String,OtpDetails> otpData=new HashMap<>();
	private static String USER_NAME="AC8ea130464bcd9ca52c1e9b13292e6dee";
	private static String PASSWORD="7275819faec4805ae598e4cd3f7e8372";
	
	@Autowired
	private JwtRequestFilter jwtTokenFilter;
	@Autowired
	private CustomerDetailsService customerDetailsService;
	
	static{
		
		Twilio.init(USER_NAME, PASSWORD);
		
	}
	
	@RequestMapping(value="/send/otp",method=RequestMethod.POST)
	public ResponseEntity<Object> getOtp(/* @PathVariable("mobileNumber") String mobileNumber */){
		
		String username=jwtTokenFilter.getUsername();
		CustomerSpecificDetails customerDetails=customerDetailsService.getCustomerDetails(username);
		System.out.println(customerDetails.getMobileNumber());
		OtpDetails otpDetails=new OtpDetails();
		otpDetails.setMobileNumber(customerDetails.getMobileNumber());
		otpDetails.setOtp(String.valueOf(898569));
		otpDetails.setExpTime(System.currentTimeMillis()+300000);
		otpData.put(customerDetails.getMobileNumber(), otpDetails);
		Message.creator(new PhoneNumber(customerDetails.getMobileNumber()), new PhoneNumber("+12055123837"),
		         "Your OTP from Explore Canada is :"+otpDetails.getOtp()).create();
		return new ResponseEntity<>("OTP send yo your mobile number",HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/verify/otp",method=RequestMethod.POST)
	public ResponseEntity<Object> validateOtp(@RequestHeader String otp){
		
		System.out.println(otp);
		String username=jwtTokenFilter.getUsername();
		CustomerSpecificDetails customerDetails=customerDetailsService.getCustomerDetails(username);
		System.out.println(customerDetails.getMobileNumber());
		String mobileNumber=customerDetails.getMobileNumber();
		
		for(String details:otpData.keySet()) {
			
			System.out.println(details);
		}
		
		if(otp==null) {
			return new ResponseEntity<>("Request Body error",HttpStatus.BAD_REQUEST);
		}
		else {
			
			if(otpData.containsKey(mobileNumber)) {
				OtpDetails theotpDetails=otpData.get(mobileNumber);
				
				if(theotpDetails!=null) {
				
						if(otp.equals(theotpDetails.getOtp())){
							
							return new ResponseEntity<>("OTP is verified",HttpStatus.OK);
						}
						else {
							return new ResponseEntity<>("Invalid OTP",HttpStatus.BAD_REQUEST);
						}
					
					
				}
			}
			
		}
		return new ResponseEntity<>("something went wrong",HttpStatus.BAD_GATEWAY);
		
	}

}
