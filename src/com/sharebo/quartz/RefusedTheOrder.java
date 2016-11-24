package com.sharebo.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.sharebo.config.QuartzConfiig;
import com.sharebo.entity.TaskInfo;
import com.sharebo.util.httpClient.HttpUtil;
/**
 * 自动拒绝订单
 * @author niewei
 *
 */
public class RefusedTheOrder extends BaseTask implements Job{
	//执行取消订单的操作
	public void execute(JobExecutionContext context) throws JobExecutionException {
		TaskInfo  task_val=(TaskInfo)context.getMergedJobDataMap().get("task");
    	if(taskrefund.get(task_val.getJobName())!=null){
    		/////////////////////////////执行任务///////////////////////////////
    		//通过jobName（订单编号） 自动取消订单
    		System.out.println("执行任务："+task_val.getJobName());
    		System.out.println("订单号："+task_val.getOrderNo());
    		String aa=HttpUtil.request_post(QuartzConfiig.AUTOMATIC_URL,"jobName="+task_val.getJobName()+"&orderNo="+task_val.getOrderNo());
    		System.out.println("调用任务："+aa);
    		///////////////////////////////////////////////////////////////////
    		taskrefund.remove(task_val.getJobName());//执行成功清理集合对象
    		TaskTimer.closeJob(task_val.getJobName());//关闭计时
    	}
    	else{
    		//添加验证——任务
    		taskrefund.put(task_val.getJobName(),task_val);
    	}
	}
	//项目初始化计时，避免服务器重启
	public void initTask(){
		System.out.println("初始化计时器~~~~~~~");
		/////////////////////////////////////////////
		//1.通过逻辑判断，查询数据库中，哪些需要计时的操作的数据
		//2.计算需要再次计时的数据
		//3.添加计时
		//4.计时处理相应的业务
		/////////////////////////////////////////////
	}
}
