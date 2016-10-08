package com.waylau.rest.bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 说明：告警 对应 d_alarm
 *
 * @author <a href="http://www.waylau.com">waylau.com</a> 2015年4月18日 
 */
@XmlRootElement
public class Alarm {
 
	private Integer id;
	private Date alarmTime;
	private Date alarmEndTime;
	private Short measurePointId;
	private String alarmCode;
	private String alarmDetail;
	private Short eId;
	
	public Alarm() {
	}
	
	public Alarm(Date alarmTime, Short measurePointId, String alarmCode, String alarmDetail) {
		this.alarmTime = alarmTime;
		this.measurePointId = measurePointId;
		this.alarmCode = alarmCode;
		this.alarmDetail = alarmDetail;
	}
	
 
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Date getAlarmTime() {
		return this.alarmTime;
	}

	public void setAlarmTime(Date alarmTime) {
		this.alarmTime = alarmTime;
	}

	public String getAlarmCode() {
		return this.alarmCode;
	}

	public void setAlarmCode(String alarmCode) {
		this.alarmCode = alarmCode;
	}

	public String getAlarmDetail() {
		return this.alarmDetail;
	}

	public void setAlarmDetail(String alarmDetail) {
		this.alarmDetail = alarmDetail;
	}
 
	public Short geteId() {
		return eId;
	}

	public void seteId(Short eId) {
		this.eId = eId;
	}
	public Date getAlarmEndTime() {
		return alarmEndTime;
	}

	public void setAlarmEndTime(Date alarmEndTime) {
		this.alarmEndTime = alarmEndTime;
	}

	public Short getMeasurePointId() {
		return measurePointId;
	}

	public void setMeasurePointId(Short measurePointId) {
		this.measurePointId = measurePointId;
	}

}
