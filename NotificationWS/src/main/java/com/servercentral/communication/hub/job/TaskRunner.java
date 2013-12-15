package com.servercentral.communication.hub.job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class TaskRunner {
	
	@Autowired
	ScheduledJob ScheduledJobService;
	//Fire at 12:00 PM (noon) every day
	@Scheduled(cron="*/5 * * * * ?")
	// every hour
	// second, minute, hour, day of month, month, day(s) of week like MON-FRI
	public void getJobsToBeRun() throws Exception {
		System.out.println("This is task Runner");
		ScheduledJobService.doJob();
	
	}
}
