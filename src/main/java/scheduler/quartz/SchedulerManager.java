package scheduler.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SchedulerManager {

	public static Logger log=LoggerFactory.getLogger(SchedulerManager.class);
	
	@Autowired
	private Scheduler scheduler;
	private String name="myjob";
	private String group="mygroup";
	public SchedulerManager setName(String name){
		this.name=name;
		return this;
	}
	public SchedulerManager setgroup(String group){
		this.group=group;
		return this;
	}
	public void startJob(Class<? extends Job> cl,String cron) throws SchedulerException{
		//通过JobBuilder构建JobDetail实例， JobDetail 是具体Job实例（RealJob）
		JobDetail jobDetail=JobBuilder.newJob(cl)
				.withIdentity(name, group).build();
		//创建触发器的时间
		CronScheduleBuilder cronSchedule=CronScheduleBuilder.cronSchedule(cron);
		//通过Trigger创建触发器
		Trigger trigger=TriggerBuilder.newTrigger().withIdentity(name, group)
				.withSchedule(cronSchedule).build();
		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();
	}
}
