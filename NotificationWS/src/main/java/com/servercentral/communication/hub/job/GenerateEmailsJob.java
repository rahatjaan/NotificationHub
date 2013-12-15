package com.servercentral.communication.hub.job;

import org.springframework.stereotype.Service;

@Service("ScheduledJobService")
public class GenerateEmailsJob implements ScheduledJob{

	public void doJob(){
		System.out.println("Inside Generate Emails Job");
	}
	
}
