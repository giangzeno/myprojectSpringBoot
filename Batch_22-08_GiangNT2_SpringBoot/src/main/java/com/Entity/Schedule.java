package com.Entity;

/** 
 * Entity
 * 
 * Version 0.0.1-SNAPSHOT
 * 
 * Date: 16-02-2023
 * 
 * Copyright 
 * 
 * Modification Logs:
 * 
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 16-02-2023            GiangNT2            Create
 *  
 * */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int")
	private int Schedule_ID;
	@Column(columnDefinition = "nvarchar(255)")
	private String Schedule_Time;

	public Schedule() {
		super();
	}

	public Schedule(int schedule_ID, String schedule_Time) {
		super();
		Schedule_ID = schedule_ID;
		Schedule_Time = schedule_Time;
	}


	public int getSchedule_ID() {
		return Schedule_ID;
	}

	public void setSchedule_ID(int schedule_ID) {
		Schedule_ID = schedule_ID;
	}

	public String getSchedule_Time() {
		return Schedule_Time;
	}

	public void setSchedule_Time(String schedule_Time) {
		Schedule_Time = schedule_Time;
	}

}
