package com.adobe.aem.msil.core.schedulers;

import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Designate(ocd=SampleScheduler.SampleConfig.class)
@Component(service=Runnable.class)
public class SampleScheduler implements Runnable{

	 private final Logger logger = LoggerFactory.getLogger(getClass());
	 
	 @Reference
	 Scheduler scheduler;
	 
	
	 @ObjectClassDefinition(name="A Sample scheduled task",
             description = "Simple demo for cron-job like task with properties")
public static @interface SampleConfig {

@AttributeDefinition(name = "Cron-job expression")
String scheduler_expression() default "*/30 * * * * ?";

@AttributeDefinition(name = "Concurrent task",
               description = "Whether or not to schedule this task concurrently")
boolean scheduler_concurrent() default false;

@AttributeDefinition(name = "A parameter",
               description = "Can be configured in /system/console/configMgr")
String myParameter() default "";
}
	
	private String cron_express;
	@Override
	public void run() {
		logger.info("I am from Scheduler");
		/// Here you service Logic can be called
	}
	
	@Activate
	public void startActivatingScheduler(SampleConfig config)
	{
	//	cron_express = config.scheduler_expression();
		addScheduler(config);
	}
	
	@Deactivate
	public void deActivatingScheduler(SampleConfig config)
	{
	//	cron_express = config.scheduler_expression();
		removeScheduler(config);
	}

	private void removeScheduler(SampleConfig config) {
		// TODO Auto-generated method stub
		scheduler.unschedule("sample-scheduler-1");
		
	}

	private void addScheduler(SampleConfig config) {
		logger.info("I am from Activating Scheduler"+config.scheduler_expression());
		
		ScheduleOptions scheduleOptions = scheduler.EXPR(config.scheduler_expression());
        scheduleOptions.name("sample-scheduler-1");
        scheduleOptions.canRunConcurrently(config.scheduler_concurrent());
        // Scheduling the job
        scheduler.schedule(this, scheduleOptions);
		
	}
	

}
