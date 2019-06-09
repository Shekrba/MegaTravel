package com.megatravel.service;



import org.springframework.stereotype.Service;


@Service
public class AgentServiceImpl implements AgentService {

	@Override
	public String sayHowAreYou(String name) {
		return name;
	}
}
