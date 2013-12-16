package com.servercentral.communication.hub.job;



public class GenerateEmailsJob implements ScheduledJob{

	public void doJob(){
		System.out.println("Inside Generate Emails Job");
	}
	
}
