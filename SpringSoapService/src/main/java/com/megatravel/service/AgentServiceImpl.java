package com.megatravel.service;



import com.megatravel.model.UserCredentials;
import org.springframework.stereotype.Service;


@Service
public class AgentServiceImpl implements AgentService {


	@Override
	public String login(UserCredentials credentials) {
		return "abcd";
	}
}
