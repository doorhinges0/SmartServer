package com.fuck.mobile.common;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import org.springframework.scheduling.Trigger;

public interface IScheduleRunner {

	void execute(Runnable run);
	
	ScheduledFuture<?> schedule(Runnable task, Trigger trigger);
	
	ScheduledFuture<?> schedule(Runnable task, Date startTime);
	
	void schedule(String key,String defCron,Runnable run);
	
}
