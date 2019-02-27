package scheduler.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Repository;

@Configuration
@Repository
public class StartJob implements ApplicationListener<ContextRefreshedEvent> {
	private static Logger log=LoggerFactory.getLogger(StartJob.class);
	@Autowired
	private SchedulerManager scheduleManager;

	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			scheduleManager.setName("name1").setgroup("group1").startJob(RealJob.class, "1-10/3 * * * * ?");;
			log.info("定时任务启动。。。。。。。。。。。。");
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	@Bean
	public Scheduler getScheduler() throws SchedulerException{
		SchedulerFactory scheduler=new StdSchedulerFactory();
		return scheduler.getScheduler();
	}
	
	
}
