package com.sharebo.entity.Dto;

import java.io.Serializable;

//订单时间表
public class OrderTimeDto implements  Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String otId;//'订单时间表主键',
	private String begin_time;//开始时间
	private String end_time;//结束时间
	private String thisDate;//'当前日期',
	private String orderid;//'订单外键（此条数据对应的是哪个订单）',
	public String getOtId() {
		return otId;
	}
	public void setOtId(String otId) {
		this.otId = otId;
	}
	public String getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(String beginTime) {
		begin_time = beginTime;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String endTime) {
		end_time = endTime;
	}
	public String getThisDate() {
		return thisDate;
	}
	public void setThisDate(String thisDate) {
		this.thisDate = thisDate;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public OrderTimeDto() {
	}
	public OrderTimeDto(String beginTime, String endTime, String thisDate) {
		this.begin_time = beginTime;
		this.end_time = endTime;
		this.thisDate = thisDate;
	}
}
