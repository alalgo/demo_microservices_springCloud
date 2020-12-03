package org.alalgo.usc.web;

import org.alalgo.usc.quartzjob.SchedulerManager;
import org.alalgo.usc.quartzjob.TestJob;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/quartz")
@Api(tags = "定时任务")
public class QuartzController {
    @Autowired
    public SchedulerManager schedulerManager;
    
    @ApiOperation("添加定时任务")
    @GetMapping("/add")
    public void AddScheduleJob() {}
    
    @ApiOperation("启动定时任务")
    @GetMapping("/start")
    public String startScheduleJob() {
    	log.info("start schedule job.");
    	try {
    		//每隔三秒执行一次
			schedulerManager.startJob("0/5 * * * * ?", "testjob", Scheduler.DEFAULT_GROUP, TestJob.class);
			return "任务启动成功.";
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
    	return "任务启动失败.";
    }
    
    @ApiOperation("删除定时任务")
    @GetMapping("/delete")
    public String stopScheduleJob() {
    	try {

			if(schedulerManager.deleteJob("testjob")) {
				return "任务删除成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "任务删除失败";
    }
}
