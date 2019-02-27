package scheduler.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RealJob implements Job{

	private static final Logger log = LoggerFactory.getLogger(RealJob.class);
	public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("任务1"+context.getJobDetail().getKey()+"   "+context.getJobDetail().getDescription());
	}
	
}
