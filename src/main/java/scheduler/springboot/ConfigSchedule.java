package scheduler.springboot;

import java.util.concurrent.Executors;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class ConfigSchedule implements SchedulingConfigurer {

	public void configureTasks(ScheduledTaskRegistrar task) {
		task.setScheduler(Executors.newScheduledThreadPool(10));
	}
	
}
