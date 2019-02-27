package scheduler.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

@Repository
public class SchedulerTest {
	Logger log=LoggerFactory.getLogger(SchedulerTest.class);
	//第一次掉用完后间隔指定时间（1000毫秒）再次执行
	//@Scheduled(fixedDelayString="3000")
//	@Scheduled(fixedDelay=4000)
	//每隔指定时间（1000毫秒）执行一次，不管第一个是否执行完
//	@Scheduled(fixedRate=5000)
	//initialDelay初始化延迟时长3000毫秒，只初始化一次，不设置则是启动就执行
	@Scheduled(initialDelay=0,fixedRate=1000)
	public void task0() throws Exception{
		Thread.sleep(5000);
		log.info("任务0");
	}
	//Cron时间表达式
	@Scheduled(cron="1-10/3 23 13 * * ?")
	public void task1(){
		log.info("任务1");
	}
	@Scheduled(cron="1-10 23 13 * * ?")
	public void task2(){
		log.info("任务2");
	}
}
