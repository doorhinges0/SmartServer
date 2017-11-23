package com.fuck.mobile.common;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

@Service
class ScheduleRunnerImp implements IScheduleRunner {

	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;
	@Autowired
	private ThreadPoolTaskScheduler taskScheduler;
	@Autowired
	private IConfigValue configValue;

	@Override
	public void execute(Runnable run) {
		taskExecutor.execute(run);
	}

	@Override
	public ScheduledFuture<?> schedule(Runnable task, Trigger trigger) {

		return taskScheduler.schedule(task, trigger);
	}

	@Override
	public ScheduledFuture<?> schedule(Runnable task, Date startTime) {
		return taskScheduler.schedule(task, startTime);
	}

	private class IConfigValueChangeEx implements IConfigValueChange<String>
	{
		ScheduledFuture<?> sf;
		Runnable run;
		IConfigValueChangeEx(Runnable run,ScheduledFuture<?> sf)
		{
			this.run = run;
			this.sf = sf;
		}
		
		
		@Override
		public void onChange(String key, String oldval, String newval) {
			if(sf != null) sf.cancel(true);
			sf = null;
			if(StringUtils.isNotEmpty(newval))
				sf = taskScheduler.schedule(run, new CronTrigger(newval));
		}
		
	}
	
	@Override
	public void schedule(String key, String defCron, Runnable run) {
		String v = defCron;
		if (configValue.exist(key)) {
			v = configValue.get(key);
			if (StringUtils.isEmpty(v)) {
				v = defCron;
			}
		}
		ScheduledFuture<?> sf = taskScheduler.schedule(run, new CronTrigger(v));
		configValue.dataChanges(key, new IConfigValueChangeEx(run,sf), defCron);
	}

}
