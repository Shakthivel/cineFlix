package com.cineFlix.service;

import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class SMSService {
	// Find your Account SID and Auth Token at twilio.com/console
	// and set the environment variables. See http://twil.io/secure
	public static final String ACCOUNT_SID_PART1 = "ACc9cd333a6cfb9c0";
	public static final String ACCOUNT_SID_PART2 = "df571d16333502da8";
	public static final String AUTH_TOKEN_PART1 = "099f1d4a2b60886000";
	public static final String AUTH_TOKEN_PART2 = "3c68b9ef469bb5";
	
	public void sendSms(String phoneNumber,String otp) {
		Twilio.init(ACCOUNT_SID_PART1+ACCOUNT_SID_PART2, AUTH_TOKEN_PART1+AUTH_TOKEN_PART2);
		Message message = Message.creator(
						new com.twilio.type.PhoneNumber("+91"+phoneNumber),
						new com.twilio.type.PhoneNumber("+17278556565"),
						otp)
				.create();

		System.out.println(message.getSid());
	}
}