package org.alalgo.usc.quartzjob;

import javax.annotation.Resource;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.JobListener;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.stereotype.Service;
/**
 * 
* @Description: 动态任务工厂类
* @author security
* @date 2019年4月12日
*
 */
@Service
public class SchedulerManager {
	 @Resource
	 private Scheduler scheduler;
	 private JobListener scheduleListener;

	    /**
	     * 添加job
	     *
	     * @param className      类名
	     * @param cronExpression cron表达式
	     * @throws Exception
	     */
	    public void addJob(String className, String cronExpression) throws Exception {
	        Class clazz = Class.forName(className);
	        JobDetail jobDetail = JobBuilder.newJob(clazz)
	                .withIdentity(className)
	                .withDescription("A test job")
	                //如果需要给任务传递参数，可以用setJobData来设置参数
	                 .setJobData(new JobDataMap())
	                .build();
	        CronTriggerImpl cronTrigger = new CronTriggerImpl();
	        cronTrigger.setName("JobTrigger:" + className);
	        cronTrigger.setCronExpression(cronExpression);
	        JobKey jobKey = new JobKey("JobName:" + className);
	        if(!scheduler.checkExists(jobKey)){
	            scheduler.scheduleJob(jobDetail, cronTrigger);
	        }
	    }
	    /**
	     * 更新job cron表达式
	     * @param quartzJob
	     * @throws SchedulerException
	     */
	    public void updateJobCron(QuartzJob quartzJob) throws SchedulerException {

	        TriggerKey triggerKey = TriggerKey.triggerKey(quartzJob.getJobName());
	        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
	        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(quartzJob.getCronExpression());
	        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
	        scheduler.rescheduleJob(triggerKey, trigger);
	    }	    
	    /**
	     * 删除一个job
	     * @param quartzJob
	     * @throws SchedulerException
	     */
	    public void deleteJob(QuartzJob quartzJob) throws SchedulerException {
	        JobKey jobKey = JobKey.jobKey(quartzJob.getJobName());
	        scheduler.deleteJob(jobKey);
	    }

	    /**
	     * 暂停job
	     *
	     * @param className 类名
	     * @throws Exception
	     */
	    public void pause(String className) throws Exception {
	        JobKey jobKey = new JobKey(className);
	        scheduler.pauseJob(jobKey);
	    }

	    /**
	     * 重启job
	     *
	     * @param className
	     * @throws Exception
	     */
	    public void resume(String className) throws Exception {
	        JobKey jobKey = new JobKey(className);
	        scheduler.resumeJob(jobKey);
	    }

	    /**
	       * 移除定时任务
	     *
	     * @param className
	     * @throws Exception
	     */
	    public boolean deleteJob(String className) throws Exception {
	        JobKey jobKey = new JobKey( className);
	        return scheduler.deleteJob(jobKey);
	    }

	    /**
	     * 修改job的执行时间
	     *
	     * @param className
	     * @param cronExpression
	     * @throws Exception
	     */
	    public void updateJobTime(String className, String cronExpression) throws Exception {
	        TriggerKey triggerKey = new TriggerKey(className);
	        CronTriggerImpl trigger = (CronTriggerImpl) scheduler.getTrigger(triggerKey);
	        if (trigger == null) {
	            return;
	        }
	        String oldTime = trigger.getCronExpression();
	        if (!oldTime.equalsIgnoreCase(cronExpression)) {
	            trigger.setCronExpression(cronExpression);
	            scheduler.rescheduleJob(triggerKey, trigger);
	        }
	    }

	    /**
	     * 获取job信息
	     * @param className
	     * @return
	     * @throws Exception
	     */
	    public JobDetail getJobDetail(String className) throws Exception {
	        JobKey jobKey = new JobKey(className);
	        JobDetail detail = scheduler.getJobDetail(jobKey);
	        return detail;
	    }
	    /**
	      * 开始定时任务
	     * @param jobName
	     * @param jobGroup
	     * @throws SchedulerException
	     */
	    public void startJob(String cron,String jobName,String jobGroup,Class<? extends Job> jobClass) throws SchedulerException
	    {
	        if(scheduleListener==null){
	            scheduleListener=new SchedulerListener();
	            scheduler.getListenerManager().addJobListener(scheduleListener);
	        }
	        JobKey jobKey=new JobKey(jobName,jobGroup);
	        if(!scheduler.checkExists(jobKey))
	        {
	            JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroup).build();
	            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
	            CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroup).withSchedule(scheduleBuilder).build();

	            scheduler.scheduleJob(jobDetail,cronTrigger);	        
	        }
	    }
	    /**
	     * 启动所有的任务
	     *
	     * @throws SchedulerException
	     */
	    public void startJobs() throws SchedulerException {
	        scheduler.start();
	    }

	    /**
	     * 关闭所有的任务
	     *
	     * @throws SchedulerException
	     */
	    public void shutdownJobs() throws SchedulerException {
	        if (!scheduler.isShutdown()) {
	            scheduler.shutdown();
	        }
	    }	 
}
