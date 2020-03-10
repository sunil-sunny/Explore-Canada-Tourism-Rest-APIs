package com.ExploreCanada.packages.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ExploreCanada.packages.OtpSystem.OtpDetails;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
public class OtpSystemRestController {
	
	private Map<String,OtpDetails> otpData=new HashMap<>();
	private static String USER_NAME="AC8ea130464bcd9ca52c1e9b13292e6dee";
	private static String PASSWORD="aa4a5e9f680345f967344f30f132d0b7";
	
	static{
		
		Twilio.init(USER_NAME, PASSWORD);
		
	}
	
	@RequestMapping(value="/send/otp/{mobileNumber}",method=RequestMethod.POST)
	public ResponseEntity<Object> getOtp(@PathVariable("mobileNumber") String mobileNumber){
		
		OtpDetails otpDetails=new OtpDetails();
		otpDetails.setMobileNumber(mobileNumber);
		otpDetails.setOtp(String.valueOf((int)((Math.random())*(10000-1000))+9999));
		otpDetails.setExpTime(System.currentTimeMillis()+300000);
		System.out.println("------Expiry Time--------"+otpDetails.getExpTime());
		otpData.put(mobileNumber, otpDetails);
		Message.creator(new PhoneNumber(mobileNumber), new PhoneNumber("+12055123837"),
		         "Your OTP from Explore Canada is"+otpDetails.getOtp()).create();
		return new ResponseEntity<>("OTP send yo your mobile number",HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/verify/otp/{mobileNumber}",method=RequestMethod.PUT)
	public ResponseEntity<Object> validateOtp(@PathVariable("mobileNumber") String mobileNumber,@RequestBody OtpDetails otpDetails){
		
		if(otpDetails==null || otpDetails.getOtp().toString().trim()==null) {
			return new ResponseEntity<>("Request Body error",HttpStatus.BAD_REQUEST);
		}
		else {
			
			if(otpData.containsKey(mobileNumber)) {
				OtpDetails theotpDetails=otpData.get(mobileNumber);
				
				if(theotpDetails!=null) {
					
					System.out.println("Current time is:"+System.currentTimeMillis());
					System.out.println("Exp time is :"+theotpDetails.getExpTime());
					
					/*
					 * if(theotpDetails.getExpTime()>System.currentTimeMillis()) {
					 * 
					 * return new ResponseEntity<>("OTP is Expired",HttpStatus.BAD_REQUEST); } else
					 */ {
						if(otpDetails.getOtp().equals(theotpDetails.getOtp())){
							
							return new ResponseEntity<>("OTP is verified",HttpStatus.OK);
						}
						else {
							return new ResponseEntity<Object>("Invalid OTP",HttpStatus.BAD_REQUEST);
						}
					}
					
				}
			}
			
		}
		return null;
		
	}

}
