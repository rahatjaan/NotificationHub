package com.servercentral.communication.hub.job;
import org.springframework.scheduling.annotation.Scheduled;

public class TaskRunner {
	
	ScheduledJob ScheduledJobService;
	
	public ScheduledJob getScheduledJobService() {
		return ScheduledJobService;
	}
	public void setScheduledJobService(ScheduledJob scheduledJobService) {
		ScheduledJobService = scheduledJobService;
	}
	//Fire at 12:00 PM (noon) every day
	@Scheduled(cron="*/5 * * * * ?")
	// every hour
	// second, minute, hour, day of month, month, day(s) of week like MON-FRI
	public void getJobsToBeRun() throws Exception {
		System.out.println("This is task Runner");
		ScheduledJobService.doJob();
	
	}
}
