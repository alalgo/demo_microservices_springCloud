package org.alalgo.usc.quartzjob;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class SchedulerListener implements JobListener {
	private static final String LISTENER_NAME = "QuartSchedulerListener";
	@Override
	public String getName() {
		return LISTENER_NAME;
	}

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
        String jobName = context.getJobDetail().getKey().toString();
        System.out.println("jobToBeExecuted");
        System.out.println("Job : " + jobName + " is going to start...");		
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
        System.out.println("jobExecutionVetoed");
	}

	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		System.out.println("jobWasExecuted");

        String jobName = context.getJobDetail().getKey().toString();
        System.out.println("Job : " + jobName + " is finished...");

        if (jobException!=null&&!jobException.getMessage().equals("")) {
            System.out.println("Exception thrown by: " + jobName
                    + " Exception: " + jobException.getMessage());
        }
	}

}
