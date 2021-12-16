package com.cineFlix.service;

import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class SMSService {
	// Find your Account SID and Auth Token at twilio.com/console
	// and set the environment variables. See http://twil.io/secure
	public static final String ACCOUNT_SID = "AC1bd3695e955440f19af28b72ac34bf03";
	public static final String AUTH_TOKEN = "6730e26a1e54c06a34aeaf764974c3e9";

	public void sendSms() {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message.creator(
						new com.twilio.type.PhoneNumber("+917904017459"),
						new com.twilio.type.PhoneNumber("+19896231969"),
						"12345")
				.create();

		System.out.println(message.getSid());
	}
}