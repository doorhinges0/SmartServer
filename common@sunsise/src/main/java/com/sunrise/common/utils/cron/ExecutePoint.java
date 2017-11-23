package com.sunrise.common.utils.cron;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.CronExpression;

public class ExecutePoint {
	private Logger log = Logger.getLogger(ExecutePoint.class);
	private String expression;
	public String year;
	public String month;
	public String day;
	public String hour;
	public String minute;
	public String second;
	public String week;
	private CronExpression cron;
	
	public ExecutePoint(String expression){
		this.expression = expression;
		parser();
	}
	
	public ExecutePoint(){}
	
	protected void parser(){
		try {
			cron = new CronExpression(expression);
		} catch (Exception e) {
			if (log.isInfoEnabled()){
				log.info("invalue executpoint expression:" + expression);
			}
		}
	}
	
	public boolean isStartPoint(Date date){
		try {
			if (date == null){
				date = new Date(System.currentTimeMillis());
			}
			return cron.isSatisfiedBy(date);
		} catch (Exception e) {
			return false;
		}
	}
	
	public void reParser(String expression){
		this.expression = expression;
		parser();
	}
}
